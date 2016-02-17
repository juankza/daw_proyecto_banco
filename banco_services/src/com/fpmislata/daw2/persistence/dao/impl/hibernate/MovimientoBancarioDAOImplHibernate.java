
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.persistence.dao.MovimientoBancarioDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class MovimientoBancarioDAOImplHibernate extends GenericDAOImplHibernate<MovimientoBancario, Integer> implements MovimientoBancarioDAO{

    @Override
    public List<MovimientoBancario> getByCuentaBancaria(int idCuentaBancaria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT m FROM MovimientoBancario m WHERE m.cuentaBancaria = :idCuentaBancaria");
        query.setInteger("idCuentaBancaria", idCuentaBancaria);
        session.beginTransaction();
        List<MovimientoBancario> movimientosBancarios = query.list();
        session.getTransaction().commit();
        return movimientosBancarios;
    }
    
}
