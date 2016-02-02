
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.core.exception.BusinessException;

import java.util.List;

public interface CuentaBancariaService extends GenericService<CuentaBancaria, Integer> {
    List<CuentaBancaria> findByNumeroCuenta(String numeroCuenta) throws BusinessException;
    List<CuentaBancaria> getCuentasByDNI(String dni) throws BusinessException;
}
