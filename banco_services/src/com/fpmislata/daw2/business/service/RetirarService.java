/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.Extraccion;
import com.fpmislata.daw2.core.exception.BusinessException;

/**
 *
 * @author Lliurex
 */
public interface RetirarService extends GenericService<Extraccion,Integer>{
    public void retirar(Extraccion extraccion) throws BusinessException;
}
