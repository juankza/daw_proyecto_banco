
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.business.service.SucursalBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.SucursalBancariaDAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SucursalBancariaServiceImpl extends GenericServiceImpl<SucursalBancaria, Integer> implements SucursalBancariaService {
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    @Override
    public List<SucursalBancaria> getSucursalesByEntidad(int idEntidadBancaria) throws BusinessException {
       return sucursalBancariaDAO.getSucursalesByEntidad(idEntidadBancaria);
    }

}
