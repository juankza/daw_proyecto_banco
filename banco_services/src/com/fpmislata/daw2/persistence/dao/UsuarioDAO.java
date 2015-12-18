
package com.fpmislata.daw2.persistence.dao;

import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.core.exception.BusinessException;

import java.util.List;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
    List<Usuario> findByNombreEquals(String nombre) throws BusinessException;
    List<Usuario> findByNombreLike(String nombre) throws BusinessException;
    Usuario getByEmail(String email) throws BusinessException;
}
