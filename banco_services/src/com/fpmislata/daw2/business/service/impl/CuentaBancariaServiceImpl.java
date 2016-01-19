/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CuentaBancaria;
import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.business.service.CuentaBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.core.util.ControlDigitGenerator;
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.daw2.persistence.dao.SucursalBancariaDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lliurex
 */
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria, Integer> implements CuentaBancariaService{
   @Autowired
   SucursalBancariaDAO sucursalBancariaDAO;
   @Autowired
   EntidadBancariaDAO entidadBancariaDAO;
    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) throws BusinessException{
        if (cuentaBancaria.getSucursalBancaria() == null) {
            throw new BusinessException(new BusinessMessage("Sucursal Bancaria","No puede ser null"));
        }
        if (cuentaBancaria.getSucursalBancaria().getEntidadBancaria() == null) {
            throw new BusinessException(new BusinessMessage("Entidad Bancaria","No puede ser null"));
        }
        SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(cuentaBancaria.getSucursalBancaria().getIdSucursalBancaria()); 
        EntidadBancaria entidadBancaria = entidadBancariaDAO.get(cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getIdEntidadBancaria());
        
        String digitoControl = ControlDigitGenerator.generateControlDigit(entidadBancaria.getCodigoEntidadBancaria(), sucursalBancaria.getCodigoSucursalBancaria(), cuentaBancaria.getNumeroCuenta());
        cuentaBancaria.setDigitoControl(digitoControl);
        return this.genericDAO.insert(cuentaBancaria);
    }
    

}
