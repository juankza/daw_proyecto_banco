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
import com.fpmislata.daw2.persistence.dao.CuentaBancariaDAO;
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.daw2.persistence.dao.SucursalBancariaDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lliurex
 */
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria, Integer> implements CuentaBancariaService{
    
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) throws BusinessException{
        List<BusinessMessage> businessMessages = new ArrayList();
        if (cuentaBancaria.getSucursalBancaria() == null) {
            businessMessages.add(new BusinessMessage("Sucursal Bancaria","No puede ser null"));
            throw new BusinessException(businessMessages);
        }
        if (cuentaBancaria.getSucursalBancaria().getEntidadBancaria() == null) {
            businessMessages.add(new BusinessMessage("Entidad Bancaria","No puede ser null"));
        }
        if (cuentaBancaria.getNumeroCuenta() == null || cuentaBancaria.getNumeroCuenta().length() != 10) {
            businessMessages.add(new BusinessMessage("Número cuenta","El número de cuenta no debe estar vacío y debe tener 10 carácteres fijos de longitud."));
        }
        
        
        if (!businessMessages.isEmpty()) {
            throw new BusinessException(businessMessages);
        }
        SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(cuentaBancaria.getSucursalBancaria().getIdSucursalBancaria()); 
        EntidadBancaria entidadBancaria = entidadBancariaDAO.get(cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getIdEntidadBancaria());
        
        String digitoControl = ControlDigitGenerator.generateControlDigit(entidadBancaria.getCodigoEntidadBancaria(), sucursalBancaria.getCodigoSucursalBancaria(), cuentaBancaria.getNumeroCuenta());
        cuentaBancaria.setDigitoControl(digitoControl);
        
        return this.genericDAO.insert(cuentaBancaria);
    }

    @Override
    public List<CuentaBancaria> findByNumeroCuenta(String numeroCuenta) throws BusinessException {
        return cuentaBancariaDAO.findByNumeroCuenta(numeroCuenta);
    }
    
    @Override
    public List<CuentaBancaria> getCuentasByDNI(String dni) throws BusinessException {
        List<CuentaBancaria> cuentas;
        
        cuentas = this.findAll();
//        for(int i = 0; i < cuentas.size(); i++) {
//            if(cuentas.get(i).getUsuario().getDni().equals(dni)) {
//                cuentas.remove(i);
//            }
//        }
        for (int i = cuentas.size(); i > 0; i--) {
            if (!cuentas.get(i-1).getUsuario().getDni().equals(dni)) {
                cuentas.remove(i-1);
            }
        }
        
        return cuentas;
    }
    
}
