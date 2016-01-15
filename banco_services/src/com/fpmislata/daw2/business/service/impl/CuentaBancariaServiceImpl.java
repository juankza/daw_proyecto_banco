/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.service.CuentaBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.util.ControlDigitGenerator;

/**
 *
 * @author Lliurex
 */
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria, Integer> implements CuentaBancariaService{
   
    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) throws BusinessException{
        String digitoControl = ControlDigitGenerator.generateControlDigit(cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria(), cuentaBancaria.getSucursalBancaria().getCodigoSucursalBancaria(), cuentaBancaria.getNumeroCuenta());
        cuentaBancaria.setDigitoControl(digitoControl);
        return this.genericDAO.insert(cuentaBancaria);
    }

}
