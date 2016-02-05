
package com.fpmislata.daw2.persistence.dao;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;


public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria, Integer>{
    CuentaBancaria getByNumeroCuenta(String numeroCuenta) throws BusinessException;
}
