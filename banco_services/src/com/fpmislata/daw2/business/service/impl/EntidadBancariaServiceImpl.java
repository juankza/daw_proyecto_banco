
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.business.service.EntidadBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EntidadBancariaServiceImpl extends GenericServiceImpl<EntidadBancaria, Integer> implements EntidadBancariaService {
    @Autowired
    private EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) throws BusinessException {
        return entidadBancariaDAO.insert(entidadBancaria);
    
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) throws BusinessException {
        return entidadBancariaDAO.update(entidadBancaria);

    }
    
    @Override
    public List<EntidadBancaria> findByNombreEquals(String nombre) throws BusinessException {
        return entidadBancariaDAO.findByNombreEquals(nombre);
    }

    @Override
    public List<EntidadBancaria> findByNombreLike(String nombre) throws BusinessException {
        return entidadBancariaDAO.findByNombreLike(nombre);
    }
    
}
