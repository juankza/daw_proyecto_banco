/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.business.service.SucursalBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import java.util.List;

/**
 *
 * @author Lliurex
 */
public class SucursalBancariaServiceImpl extends GenericServiceImpl<SucursalBancaria, Integer> implements SucursalBancariaService{

    @Override
    public List<SucursalBancaria> getSucursalesByEntidad(int idEntidadBancaria) throws BusinessException {
        List<SucursalBancaria> sucursales;
        
        try {
            sucursales = this.findAll();
            for (int i = 0; i < sucursales.size(); i++) {
                if (sucursales.get(i).getEntidadBancaria().getIdEntidadBancaria() != idEntidadBancaria) {
                    sucursales.remove(i);
                }
            }
        } catch (BusinessException bex) {
            throw new BusinessException(bex);
        }
        return sucursales;
    }

}
