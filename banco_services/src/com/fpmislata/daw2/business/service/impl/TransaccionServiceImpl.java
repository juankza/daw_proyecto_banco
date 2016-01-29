
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.business.domain.TipoMovimientoBancario;
import com.fpmislata.daw2.business.domain.Transaccion;

import com.fpmislata.daw2.business.service.MovimientoBancarioService;
import com.fpmislata.daw2.business.service.TransaccionService;

import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;

import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;

import java.math.BigDecimal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class TransaccionServiceImpl extends GenericServiceImpl<Transaccion, Integer> implements TransaccionService {
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    @Autowired
    MovimientoBancarioService movimientoBancarioService;

    @Override
    public Transaccion insertaTransaccion(Transaccion transaccion) throws BusinessException {
        MovimientoBancario movimientoBancarioOrigen = null, movimientoBancarioDestino = null;
        String numCuentaBancariaOrigen = transaccion.getCuentaOrigen().trim().substring(10, 20);
        String numCuentaBancariaDestino = transaccion.getCuentaDestino().trim().substring(10, 20);

        CuentaBancaria cuentaBancariaOrigen = cuentaBancariaDAO.findByNumeroCuenta(numCuentaBancariaOrigen).get(0);
        CuentaBancaria cuentaBancariaDestino = cuentaBancariaDAO.findByNumeroCuenta(numCuentaBancariaDestino).get(0);
        //si el importe es negativo esto; si es positivo al contrario
        if (transaccion.getImporte().compareTo(BigDecimal.ZERO) > 0) {
            movimientoBancarioOrigen = new MovimientoBancario(TipoMovimientoBancario.INGRESO, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaOrigen.getSaldo().add(transaccion.getImporte()), new Date(), cuentaBancariaOrigen);
            movimientoBancarioDestino = new MovimientoBancario(TipoMovimientoBancario.DEDUCCION, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaDestino.getSaldo().subtract(transaccion.getImporte()), new Date(), cuentaBancariaDestino);
        } else if (transaccion.getImporte().compareTo(BigDecimal.ZERO) < 0) {
            movimientoBancarioOrigen = new MovimientoBancario(TipoMovimientoBancario.DEDUCCION, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaOrigen.getSaldo().add(transaccion.getImporte()), new Date(), cuentaBancariaOrigen);
            movimientoBancarioDestino = new MovimientoBancario(TipoMovimientoBancario.INGRESO, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaDestino.getSaldo().subtract(transaccion.getImporte()), new Date(), cuentaBancariaDestino);
        } else {
            throw new BusinessException(new BusinessMessage("Cantidad Transaccion","La cantidad debe ser diferente de 0"));
        }
        
        movimientoBancarioService.insert(movimientoBancarioOrigen);
        movimientoBancarioService.insert(movimientoBancarioDestino);
        return transaccion;
    }

}
