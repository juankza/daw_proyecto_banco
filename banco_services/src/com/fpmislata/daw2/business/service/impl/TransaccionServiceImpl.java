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

public class TransaccionServiceImpl extends GenericServiceImpl<Transaccion, Integer> implements TransaccionService {

  
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    @Autowired
    MovimientoBancarioService movimientoBancarioService;
    @Autowired
    BancoCentralService bancoCentralService;

    @Override
    public Transaccion insertarTransaccion(Transaccion transaccion) throws BusinessException {
        CredencialBancoCentral credencialBancoCentral = new CredencialBancoCentral(transaccion.getCuentaOrigen(), "0000");
   
        CredencialBancoAjeno credencialBancoAjeno = this.getUrlByCCC(credencialBancoCentral);
        
        Extraccion extraccion = new Extraccion(transaccion.getCuentaOrigen(),transaccion.getImporte(),credencialBancoAjeno.getToken(),transaccion.getConcepto());
        
        this.retirar(credencialBancoAjeno.getUrl(), extraccion);
        
        this.MovimientoHaber(transaccion.getImporte(), transaccion.getConcepto(), transaccion.getCuentaDestino());
        
        
        return transaccion;
    }
    
    private CredencialBancoAjeno getUrlByCCC(CredencialBancoCentral credencialBancoCentral) throws BusinessException{
        try {
            return bancoCentralService.getUrlByNumeroCuenta(credencialBancoCentral);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        }
    }
    
    private void MovimientoHaber(BigDecimal importe, String concepto, String ccc) throws BusinessException{
        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.getByNumeroCuenta(ccc);
        MovimientoBancario movimientoBancario = new MovimientoBancario(TipoMovimientoBancario.DEBER, concepto, importe, importe, new Date(), cuentaBancaria);
        movimientoBancarioService.insert(movimientoBancario);
    }
    private void retirar(String url, Extraccion extraccion){
        
    }

   

}
