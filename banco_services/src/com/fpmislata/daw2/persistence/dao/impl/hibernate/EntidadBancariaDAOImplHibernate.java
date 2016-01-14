
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;

import java.util.List;

import org.hibernate.Session;

public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria, Integer> implements EntidadBancariaDAO{

    @Override
    public List<EntidadBancaria> findByNombreEquals(String nombre) throws BusinessException {
        List<EntidadBancaria> entidadesBancarias;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        entidadesBancarias = session.createQuery("SELECT eb FROM " + getEntityClass().getName() + " eb WHERE nombre = :nombre")
                .setString("nombre", nombre)
                .list();
        session.getTransaction().commit();
        session.close();
        
        return entidadesBancarias;
    }

    @Override
    public List<EntidadBancaria> findByNombreLike(String nombre) throws BusinessException {
        List<EntidadBancaria> entidadesBancarias;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        entidadesBancarias = session.createQuery("SELECT eb FROM " + getEntityClass().getName() + " eb WHERE nombre like :nombre")
                .setString("nombre", "%" + nombre + "%")
                .list();
        session.getTransaction().commit();
        session.close();
        
        return entidadesBancarias;
    }
    
}
