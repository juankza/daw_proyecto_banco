
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;

import java.util.List;

import org.hibernate.Session;

public class CuentaBancariaDAOImplHibernate extends GenericDAOImplHibernate<CuentaBancaria, Integer> implements CuentaBancariaDAO{

    @Override
    public CuentaBancaria getByNumeroCuenta(String numeroCuenta) throws BusinessException {
        int idCuentaBancaria;
        CuentaBancaria cuentaBancaria;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        idCuentaBancaria = (int)session.createQuery("SELECT cb.idCuentaBancaria FROM " + getEntityClass().getName() + " cb WHERE numeroCuenta = :numeroCuenta")
                .setString("numeroCuenta", numeroCuenta).
                uniqueResult();
        session.getTransaction().commit();
        cuentaBancaria = this.get(idCuentaBancaria);
        
        return cuentaBancaria;
    }
    
}
