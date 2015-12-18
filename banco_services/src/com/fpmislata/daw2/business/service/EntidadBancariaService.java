
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;

import java.util.List;

public interface EntidadBancariaService extends GenericService<EntidadBancaria, Integer> {
    List<EntidadBancaria> findByNombreEquals(String nombre) throws BusinessException;
    List<EntidadBancaria> findByNombreLike(String nombre) throws BusinessException;
}
