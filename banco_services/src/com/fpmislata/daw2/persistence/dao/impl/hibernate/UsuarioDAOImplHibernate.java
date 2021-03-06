
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.persistence.dao.UsuarioDAO;

import java.util.List;
import org.hibernate.Session;

public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario, Integer> implements UsuarioDAO{

    @Override
    public List<Usuario> findByNombreEquals(String nombre) throws BusinessException {
        return null;
    }

    @Override
    public List<Usuario> findByNombreLike(String nombre) throws BusinessException {
        return null;
    }
    
    @Override
    public Usuario getByEmail(String email) throws BusinessException {
        List<Usuario> usuarios;
        Usuario usuario;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        usuarios = session.createQuery("SELECT u FROM " + getEntityClass().getName() + " u WHERE email = :email").setString("email", email).list();
        session.getTransaction().commit();
        session.close();

        if(usuarios.isEmpty()) {
            usuario = null;
        } else {
            usuario = usuarios.get(0);
        }
        
        return usuario;
    }
    
}
