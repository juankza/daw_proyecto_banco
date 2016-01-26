
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.business.domain.TipoMovimientoBancario;
import com.fpmislata.daw2.business.service.MovimientoBancarioService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MovimientoBancarioServiceImpl extends GenericServiceImpl<MovimientoBancario, Integer> implements MovimientoBancarioService {
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    
    @Override
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) throws BusinessException{
        if (movimientoBancario.getCantidad()==null) {
           throw new BusinessException(new BusinessMessage("Cantidad","No puede ser nula."));
        }
        BigDecimal saldoPosterior;
        
        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(movimientoBancario.getCuentaBancaria().getIdCuentaBancaria());
        if (movimientoBancario.getTipoMovimientoBancario() == TipoMovimientoBancario.INGRESO) {
            saldoPosterior = cuentaBancaria.getSaldo().add(movimientoBancario.getCantidad());
        } else if (movimientoBancario.getTipoMovimientoBancario() == TipoMovimientoBancario.DEDUCCION) {
            saldoPosterior = cuentaBancaria.getSaldo().subtract(movimientoBancario.getCantidad());
        } else {
            throw new BusinessException(new BusinessMessage("Tipo Movimiento","El tipo de movimiento es inválido"));
        }
        
        cuentaBancaria.setSaldo(saldoPosterior);
        
        movimientoBancario.setSaldo(saldoPosterior);
        cuentaBancariaDAO.update(cuentaBancaria);
        movimientoBancario.setCuentaBancaria(cuentaBancaria);
        return this.genericDAO.insert(movimientoBancario);
    }

    @Override
    public List<MovimientoBancario> getMovimientosByCuenta(int idCuentaBancaria) throws BusinessException {
        List<MovimientoBancario> movimientos;
        try {
            movimientos = this.findAll();
            for (int i = movimientos.size(); i > 0; i--) {
                if (movimientos.get(i-1).getCuentaBancaria().getIdCuentaBancaria() != idCuentaBancaria) {
                    movimientos.remove(i-1);
                }
            }
        } catch (BusinessException bex) {
            throw new BusinessException(bex);
        }
        return movimientos;
    }
}
