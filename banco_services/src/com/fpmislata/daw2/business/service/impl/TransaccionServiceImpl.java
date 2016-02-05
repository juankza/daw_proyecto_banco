
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
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;

import java.math.BigDecimal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class TransaccionServiceImpl extends GenericServiceImpl<Transaccion, Integer> implements TransaccionService {
    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    @Autowired
    MovimientoBancarioService movimientoBancarioService;

    @Override
    public Transaccion insertaTransaccion(Transaccion transaccion) throws BusinessException {
        MovimientoBancario movimientoBancarioOrigen = null, movimientoBancarioDestino = null;
        
        if(transaccion.getCuentaOrigen().length() != 20 || !transaccion.getCuentaOrigen().matches("[0-9]+")) {
            throw new BusinessException(new BusinessMessage("Cuenta Origen","Introduce los datos de la cuenta origen correctamente"));
        }
        if(transaccion.getCuentaDestino().length() != 20 || !transaccion.getCuentaDestino().matches("[0-9]+")) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino","Introduce los datos de la cuenta destino correctamente"));
        }
        
        String numEntidadBancariaOrigen = transaccion.getCuentaOrigen().trim().substring(0, 4);
        String numSucursalBancariaOrigen = transaccion.getCuentaOrigen().trim().substring(4, 8);
        String numDigitoControlOrigen = transaccion.getCuentaOrigen().trim().substring(8, 10);
        String numCuentaBancariaOrigen = transaccion.getCuentaOrigen().trim().substring(10, 20);
        
        String numEntidadBancariaDestino = transaccion.getCuentaDestino().trim().substring(0, 4);
        String numSucursalBancariaDestino = transaccion.getCuentaDestino().trim().substring(4, 8);
        String numDigitoControlDestino = transaccion.getCuentaDestino().trim().substring(8, 10);
        String numCuentaBancariaDestino = transaccion.getCuentaDestino().trim().substring(10, 20);
        
        CuentaBancaria cuentaBancariaOrigen = cuentaBancariaDAO.getByNumeroCuenta(numCuentaBancariaOrigen);
        CuentaBancaria cuentaBancariaDestino = cuentaBancariaDAO.getByNumeroCuenta(numCuentaBancariaDestino);
        
        // Se puede optimizar guardando en un objeto para que no haya que hacer la petición dos veces
        if(cuentaBancariaOrigen == null) {
           throw new BusinessException(new BusinessMessage("Cuenta Origen","Introduce los datos de la cuenta orígen corectamente"));
        }
        if(cuentaBancariaDestino == null) {
           throw new BusinessException(new BusinessMessage("Cuenta Destino","Introduce los datos de la cuenta orígen corectamente"));
        }
        
        // Comprobar que los cuatro primeros digitos (cod entidad coinciden con su entidad;
        // que los cuatro segundos con la sucursal y los dos siguientes con el dígito de control.
        // ---- el código de error está bien?
        
        if(!cuentaBancariaOrigen.getDigitoControl().equals(numDigitoControlOrigen)) {
            throw new BusinessException(new BusinessMessage("Cuenta Origen","Introduce el dígito de control correctamente"));
        }
        if(!cuentaBancariaOrigen.getSucursalBancaria().getCodigoSucursalBancaria().equals(numSucursalBancariaOrigen)) {
            throw new BusinessException(new BusinessMessage("Cuenta Origen","Introduce el código de sucursal correctamente"));
        }
        if(!cuentaBancariaOrigen.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria().equals(numEntidadBancariaOrigen)) {
            throw new BusinessException(new BusinessMessage("Cuenta Origen","Introduce el código de entidad correctamente"));
        }
        
        if(!cuentaBancariaDestino.getDigitoControl().equals(numDigitoControlDestino)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino","Introduce el dígito de control correctamente"));
        }
        if(!cuentaBancariaDestino.getSucursalBancaria().getCodigoSucursalBancaria().equals(numSucursalBancariaDestino)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino","Introduce el código de sucursal correctamente"));
        }
        if(!cuentaBancariaDestino.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria().equals(numEntidadBancariaDestino)) {
            throw new BusinessException(new BusinessMessage("Cuenta Destino","Introduce el código de entidad correctamente"));
        }
        
        //si el importe es negativo esto; si es positivo al contrario
        if (transaccion.getImporte().compareTo(BigDecimal.ZERO) < 0) {
            movimientoBancarioOrigen = new MovimientoBancario(TipoMovimientoBancario.HABER, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaOrigen.getSaldo().add(transaccion.getImporte()), new Date(), cuentaBancariaOrigen);
            movimientoBancarioDestino = new MovimientoBancario(TipoMovimientoBancario.DEBER, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaDestino.getSaldo().subtract(transaccion.getImporte()), new Date(), cuentaBancariaDestino);
        } else if (transaccion.getImporte().compareTo(BigDecimal.ZERO) > 0) {
            movimientoBancarioOrigen = new MovimientoBancario(TipoMovimientoBancario.DEBER, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaOrigen.getSaldo().add(transaccion.getImporte()), new Date(), cuentaBancariaOrigen);
            movimientoBancarioDestino = new MovimientoBancario(TipoMovimientoBancario.HABER, transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaDestino.getSaldo().subtract(transaccion.getImporte()), new Date(), cuentaBancariaDestino);
        } else {
            throw new BusinessException(new BusinessMessage("Cantidad Transaccion","La cantidad debe ser diferente de 0"));
        }
        
        if(!cuentaBancariaOrigen.getPin().equals(transaccion.getPin())) {
            throw new BusinessException(new BusinessMessage("PIN","Pin incorrecto"));
        }
        
        movimientoBancarioService.insert(movimientoBancarioOrigen);
        movimientoBancarioService.insert(movimientoBancarioDestino);
        return transaccion;
    }

}
