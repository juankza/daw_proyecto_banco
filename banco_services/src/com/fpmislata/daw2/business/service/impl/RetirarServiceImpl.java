package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.Extraccion;
import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.business.domain.TipoMovimientoBancario;
import com.fpmislata.daw2.business.service.MovimientoBancarioService;
import com.fpmislata.daw2.business.service.RetirarService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

public class RetirarServiceImpl extends GenericServiceImpl<Extraccion,Integer> implements RetirarService {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    @Autowired
    MovimientoBancarioService movimientoBancarioService;

    @Override
    public void retirar(Extraccion extraccion) throws BusinessException {
        if (!extraccion.getToken().equals("0000")) {
            throw new BusinessException(new BusinessMessage("PIN", "Pin inválido."));
        }
        if (extraccion.getImporte() == null) {
            throw new BusinessException(new BusinessMessage("Importe", "No puede ser nulo."));
        }
        if (extraccion.getConcepto() == null || extraccion.getConcepto().trim().equals("")) {
            throw new BusinessException(new BusinessMessage("Concepto", "No puede ser nulo."));

        }
        String codigoEntidadBancaria = extraccion.getCodigoCuentaCorriente().substring(0, 4);
        String codigoSucursalBancaria = extraccion.getCodigoCuentaCorriente().substring(4, 8);
        String digitoControl = extraccion.getCodigoCuentaCorriente().substring(8, 10);
        String codigoCuentaBancaria = extraccion.getCodigoCuentaCorriente().substring(10, 20);

        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.getByNumeroCuenta(codigoCuentaBancaria);

        if (cuentaBancaria == null) {
            throw new BusinessException(new BusinessMessage("Cuenta bancaria", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getNumeroCuenta().equals(codigoCuentaBancaria)) {
            throw new BusinessException(new BusinessMessage("Cuenta bancaria", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getSucursalBancaria().getCodigoSucursalBancaria().equals(codigoSucursalBancaria)) {
            throw new BusinessException(new BusinessMessage("Cuenta bancaria", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria().equals(codigoEntidadBancaria)) {
            throw new BusinessException(new BusinessMessage("Cuenta bancaria", "Introduce los datos de la cuenta correctamente."));
        }
        if (!cuentaBancaria.getDigitoControl().equals(digitoControl)) {
            throw new BusinessException(new BusinessMessage("Cuenta bancaria", "Introduce los datos de la cuenta correctamente."));
        }

        MovimientoBancario movimientoBancario = new MovimientoBancario(TipoMovimientoBancario.DEBER, extraccion.getConcepto(), extraccion.getImporte(), cuentaBancaria.getSaldo().subtract(extraccion.getImporte()), new Date(), cuentaBancaria);
        movimientoBancarioService.insert(movimientoBancario);
    }

}
