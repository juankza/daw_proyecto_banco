/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.persistence.dao;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;

import java.util.List;

/**
 *
 * @author Lliurex
 */
public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria, Integer>{
    List<CuentaBancaria> findByNumeroCuenta(String numeroCuenta) throws BusinessException;
}
