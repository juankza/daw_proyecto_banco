
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.GenericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public T get(ID id) throws BusinessException {
        T t;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        t = (T)session.get(getEntityClass(), id);
        session.getTransaction().commit();
        session.close();
        
        return t;
    }

    @Override
    public T insert(T entity) throws BusinessException {
        T t;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        t = (T)session.save(entity);
        session.getTransaction().commit();
        session.close();
        
        return t;
    }

    @Override
    public T update(T entity) throws BusinessException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        
        return entity;
    }

    @Override
    public boolean delete(ID id) throws BusinessException {
        T t;
        boolean result;
        
        Session session = sessionFactory.openSession();
        
        t = get(id);
        if(t != null) {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            result = true;
        } else {
            result = false;
        }
        
        session.close();
        return result;
    }

    @Override
    public List<T> findAll() throws BusinessException {
        List<T> ts;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ts = session.createQuery("SELECT t FROM " + getEntityClass().getName() + " t").list();
        session.getTransaction().commit();
        session.close();
        
        return ts;
    }

    protected Class<T> getEntityClass() {
        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
}
