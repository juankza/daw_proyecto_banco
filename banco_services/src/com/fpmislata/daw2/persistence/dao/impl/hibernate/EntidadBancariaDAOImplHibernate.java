
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;

import java.util.List;

public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria, Integer> implements EntidadBancariaDAO{

    @Override
    public List<EntidadBancaria> findByNombreEquals(String nombre) throws BusinessException {
        return null;
    }

    @Override
    public List<EntidadBancaria> findByNombreLike(String nombre) throws BusinessException {
        return null;
    }

}
