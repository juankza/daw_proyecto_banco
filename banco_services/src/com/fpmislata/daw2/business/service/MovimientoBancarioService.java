
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.core.exception.BusinessException;
import java.util.List;

public interface MovimientoBancarioService extends GenericService<MovimientoBancario, Integer> {
    public List<MovimientoBancario> getMovimientosByCuenta(int idCuentaBancaria) throws BusinessException;
}
