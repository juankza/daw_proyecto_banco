
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import java.util.List;

public interface SucursalBancariaService extends GenericService<SucursalBancaria, Integer> {
public List<SucursalBancaria> getSucursalesByEntidad(int idEntidadBancaria) throws BusinessException;
}
