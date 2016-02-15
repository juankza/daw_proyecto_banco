package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CredencialBancoAjeno;
import com.fpmislata.daw2.business.domain.CredencialBancoCentral;
import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.Extraccion;
import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.business.domain.TipoMovimientoBancario;
import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.business.service.MovimientoBancarioService;
import com.fpmislata.daw2.business.service.TransaccionService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;
import java.math.BigDecimal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.fpmislata.daw2.business.service.BancoCentralService;
import com.fpmislata.daw2.business.service.RetirarHttpService;
import com.fpmislata.daw2.core.exception.BusinessMessage;

public class TransaccionServiceImpl extends GenericServiceImpl<Transaccion, Integer> implements TransaccionService {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    @Autowired
    MovimientoBancarioService movimientoBancarioService;
    @Autowired
    BancoCentralService bancoCentralService;
    @Autowired
    RetirarHttpService retirarHttpService;

    @Override
    public Transaccion insertarTransaccion(Transaccion transaccion) throws BusinessException {
        String ccc = transaccion.getCuentaDestino();
        if (ccc.length() != 20 || !ccc.matches("[0-9]+")) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }

        String codigoEntidadBancaria = ccc.substring(0, 4);

        CredencialBancoCentral credencialBancoCentral = new CredencialBancoCentral(transaccion.getCuentaOrigen(), "0000", codigoEntidadBancaria);

        CredencialBancoAjeno credencialBancoAjeno = this.getUrlByCCC(credencialBancoCentral);

        Extraccion extraccion = new Extraccion(transaccion.getCuentaOrigen(), transaccion.getImporte(), credencialBancoAjeno.getToken(), transaccion.getConcepto());

        this.retirar(credencialBancoAjeno.getUrl(), extraccion);

        this.movimientoHaber(transaccion.getImporte(), transaccion.getConcepto(), transaccion.getCuentaDestino(), transaccion.getPin());

        return transaccion;
    }

    private CredencialBancoAjeno getUrlByCCC(CredencialBancoCentral credencialBancoCentral) throws BusinessException {

        return bancoCentralService.getUrlByNumeroCuenta(credencialBancoCentral);
        

    }

    private void movimientoHaber(BigDecimal importe, String concepto, String ccc, String pin) throws BusinessException {
        if (ccc.length() != 20 || !ccc.matches("[0-9]+")) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }

        String codigoEntidadBancaria = ccc.substring(0, 4);
        String codigoSucursalBancaria = ccc.substring(4, 8);
        String digitoControl = ccc.substring(8, 10);
        String codigoCuentaBancaria = ccc.substring(10, 20);

        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.getByNumeroCuenta(codigoCuentaBancaria);
        if (cuentaBancaria == null) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getNumeroCuenta().equals(codigoCuentaBancaria)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getSucursalBancaria().getCodigoSucursalBancaria().equals(codigoSucursalBancaria)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria().equals(codigoEntidadBancaria)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getDigitoControl().equals(digitoControl)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getPin().equals(pin)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino", "Introduce los datos de la cuenta correctamente."));
        }

        MovimientoBancario movimientoBancario = new MovimientoBancario(TipoMovimientoBancario.HABER, concepto, importe, cuentaBancaria.getSaldo().add(importe), new Date(), cuentaBancaria);
        movimientoBancarioService.insert(movimientoBancario);
    }

    private void retirar(String url, Extraccion extraccion) throws BusinessException {
        retirarHttpService.retirar(url, extraccion);
    }

}
