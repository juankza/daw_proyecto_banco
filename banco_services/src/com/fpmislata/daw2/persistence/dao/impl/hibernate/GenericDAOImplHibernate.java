package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.GenericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public T get(ID id) throws BusinessException {
        T entity;
        Session session;

        //session = sessionFactory.openSession();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        entity = (T) session.get(getEntityClass(), id);
        //session.close();

        return entity;
    }

    @Override
    public T insert(T entity) throws BusinessException {
        Session session;
        try {
            //session = sessionFactory.openSession();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            //session.close();

            return entity;
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        }
    }

    @Override
    public T update(T entity) throws BusinessException {
        Session session;
        try {
            //session = sessionFactory.openSession();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            //session.close();

            return entity;
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        }
    }

    @Override
    public boolean delete(ID id) throws BusinessException {
        T entity;
        Session session;
        boolean result;
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session = sessionFactory.openSession();

        entity = get(id);
        if (entity != null) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            result = true;
        } else {
            result = false;
        }

        //session.close();
        return result;
    }

    @Override
    public List<T> findAll() throws BusinessException {
        List<T> entities;
        Session session;

        session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT entity FROM " + getEntityClass().getName() + " entity").list();
        session.getTransaction().commit();
        //session.close();

        return entities;
    }

    protected Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
