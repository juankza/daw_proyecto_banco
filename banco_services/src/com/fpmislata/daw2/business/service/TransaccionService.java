
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.core.exception.BusinessException;

public interface TransaccionService extends GenericService<Transaccion, Integer> {
    public Transaccion ingresar(Transaccion transaccion) throws BusinessException;
    public Transaccion retirar(Transaccion transaccion) throws BusinessException;
}
