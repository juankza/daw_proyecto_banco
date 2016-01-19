/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;

import java.util.List;

import org.hibernate.Session;

/**
 *
 * @author Lliurex
 */
public class CuentaBancariaDAOImplHibernate extends GenericDAOImplHibernate<CuentaBancaria, Integer> implements CuentaBancariaDAO{

    @Override
    public List<CuentaBancaria> findByNumeroCuenta(String numeroCuenta) throws BusinessException {
        List<CuentaBancaria> cuentasBancarias;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        cuentasBancarias = session.createQuery("SELECT cb FROM " + getEntityClass().getName() + " cb WHERE numeroCuenta = :numeroCuenta")
                .setString("numeroCuenta", numeroCuenta)
                .list();
        session.getTransaction().commit();
        
        
        return cuentasBancarias;
    }
    
}
