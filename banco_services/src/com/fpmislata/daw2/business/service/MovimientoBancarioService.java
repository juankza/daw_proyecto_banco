/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.core.exception.BusinessException;
import java.util.List;

/**
 *
 * @author Lliurex
 */
public interface MovimientoBancarioService extends GenericService<MovimientoBancario, Integer> {
    public List<MovimientoBancario> getMovimientosByCuenta(int idCuentaBancaria) throws BusinessException;
}
