
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.persistence.dao.SucursalBancariaDAO;
import java.util.List;
import org.hibernate.Session;

public class SucursalBancariaDAOImplHibernate extends GenericDAOImplHibernate<SucursalBancaria, Integer> implements SucursalBancariaDAO {
//    @Override
//    public List<SucursalBancaria> getSucursalesByEntidad(int idEntidadBancaria){
//        List<SucursalBancaria> sucursales;
//        Session session;
//
//        session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//        sucursales = session.createQuery("SELECT sb FROM " + getEntityClass().getName() + " sb WHERE idEntidadBancaria = :idEntidadBancaria")
//                .setInteger("idEntidadBancaria", idEntidadBancaria)
//                .list();
//        session.getTransaction().commit();
//        //session.close();
//
//        return sucursales;
//        
//        
//        
//    }
}
