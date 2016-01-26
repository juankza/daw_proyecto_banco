
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.business.domain.TipoMovimientoBancario;
import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.business.service.TransaccionService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

public class TransaccionServiceImpl extends GenericServiceImpl<Transaccion, Integer> implements TransaccionService{
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    
    @Override
    public boolean insertaTransaccion(Transaccion transaccion) throws BusinessException {
        /*transaccion.getCuentaOrigen().trim().substring(0, 4);
        transaccion.getCuentaOrigen().trim().substring(4, 8);
        transaccion.getCuentaOrigen().trim().substring(8, 10);*/
        String numCuentaBancariaOrigen = transaccion.getCuentaOrigen().trim().substring(10, 20);
        String numCuentaBancariaDestino = transaccion.getCuentaDestino().trim().substring(10, 20);
                
        CuentaBancaria cuentaBancariaOrigen = cuentaBancariaDAO.findByNumeroCuenta(numCuentaBancariaOrigen).get(0);
        CuentaBancaria cuentaBancariaDestino = cuentaBancariaDAO.findByNumeroCuenta(numCuentaBancariaDestino).get(0);
        //si el importe es negativo esto; si es positivo al contrario
        MovimientoBancario movimientoBancarioHaber = 
                new MovimientoBancario(TipoMovimientoBancario.INGRESO, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaOrigen.getSaldo().add(transaccion.getImporte()), new Date(), cuentaBancariaOrigen);
        
        MovimientoBancario movimientoBancarioDeber = 
                new MovimientoBancario(TipoMovimientoBancario.DEDUCCION, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaDestino.getSaldo().subtract(transaccion.getImporte()), new Date(), cuentaBancariaDestino);
        
        /*
        -crea movimiento bancario
            -tiene cuentabanc, hay que sacar el objeto
        */
//        CuentaBancaria cuentaBancaria = 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
