
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.business.service.SucursalBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import java.util.List;

public class SucursalBancariaServiceImpl extends GenericServiceImpl<SucursalBancaria, Integer> implements SucursalBancariaService {

    @Override
    public List<SucursalBancaria> getSucursalesByEntidad(int idEntidadBancaria) throws BusinessException {
        List<SucursalBancaria> sucursales;

        try {
            sucursales = this.findAll();

            for (int i = sucursales.size(); i > 0; i--) {
                if (sucursales.get(i-1).getEntidadBancaria().getIdEntidadBancaria() != idEntidadBancaria) {
                    sucursales.remove(i-1);
                }
            }
        } catch (BusinessException bex) {
            throw new BusinessException(bex);
        }
        return sucursales;
    }

}
