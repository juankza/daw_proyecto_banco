
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;

import java.util.List;

import org.hibernate.Session;

public class CuentaBancariaDAOImplHibernate extends GenericDAOImplHibernate<CuentaBancaria, Integer> implements CuentaBancariaDAO{

    @Override
    public CuentaBancaria findByNumeroCuenta(String numeroCuenta) throws BusinessException {
        CuentaBancaria cuentaBancarias;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        cuentaBancarias = (CuentaBancaria)session.createQuery("SELECT cb FROM " + getEntityClass().getName() + " cb WHERE numeroCuenta = :numeroCuenta")
                .setString("numeroCuenta", numeroCuenta)
                .uniqueResult();
        session.getTransaction().commit();
        
        
        return cuentaBancarias;
    }
    
}
