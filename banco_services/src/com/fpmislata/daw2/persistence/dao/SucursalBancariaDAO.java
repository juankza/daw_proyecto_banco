
package com.fpmislata.daw2.persistence.dao;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import java.util.List;

public interface SucursalBancariaDAO extends GenericDAO<SucursalBancaria, Integer> {
    
    public List<SucursalBancaria> getSucursalesByEntidad(int idEntidadBancaria) throws BusinessException;
}
