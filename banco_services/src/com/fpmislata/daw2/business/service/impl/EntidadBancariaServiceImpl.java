
package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.business.service.EntidadBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.persistence.dao.EntidadBancariaDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EntidadBancariaServiceImpl extends GenericServiceImpl<EntidadBancaria, Integer> implements EntidadBancariaService {
    @Autowired
    private EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) throws BusinessException {
        List<BusinessMessage> businessMessages;
        businessMessages = new ArrayList<>();
        
        if(entidadBancaria.getNombre() == null || entidadBancaria.getNombre().trim().equals("")) {
            businessMessages.add(new BusinessMessage("Nombre", "No puede estar vacío"));
        }
        
        if(entidadBancaria.getCodigoEntidadBancaria().length() != 4) {
            businessMessages.add(new BusinessMessage("Codigo Entidad Bancaria", "Debe contener 4 carácteres"));
        }
        
        if(entidadBancaria.getFechaCreacion() == null) {
            businessMessages.add(new BusinessMessage("Fecha Creacion", "No puede estar vacío"));
        }
        
        if(entidadBancaria.getDireccion() == null || entidadBancaria.getDireccion().trim().equals("")) {
            businessMessages.add(new BusinessMessage("Direccion", "No puede estar vacío"));
        }
        
        if(entidadBancaria.getCif() == null || entidadBancaria.getCif().trim().equals("")) {
            businessMessages.add(new BusinessMessage("CIF", "No puede estar vacío"));
        }

        if(!businessMessages.isEmpty()) {
            throw new BusinessException(businessMessages);
        }
        
        return entidadBancariaDAO.insert(entidadBancaria);
    
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) throws BusinessException {
        List<BusinessMessage> businessMessages;
        businessMessages = new ArrayList<>();
        
        if(entidadBancaria.getNombre() == null || entidadBancaria.getNombre().trim().equals("")) {
            businessMessages.add(new BusinessMessage("Nombre", "No puede estar vacío"));
        }
        
        if(entidadBancaria.getCodigoEntidadBancaria().length() != 4) {
            businessMessages.add(new BusinessMessage("Codigo Entidad Bancaria", "Debe contener 4 carácteres"));
        }
        
        if(entidadBancaria.getFechaCreacion() == null) {
            businessMessages.add(new BusinessMessage("Fecha Creacion", "No puede estar vacío"));
        }
        
        if(entidadBancaria.getDireccion() == null || entidadBancaria.getDireccion().trim().equals("")) {
            businessMessages.add(new BusinessMessage("Direccion", "No puede estar vacío"));
        }
        
        if(entidadBancaria.getCif() == null || entidadBancaria.getCif().trim().equals("")) {
            businessMessages.add(new BusinessMessage("CIF", "No puede estar vacío"));
        }

        if(!businessMessages.isEmpty()) {
            throw new BusinessException(businessMessages);
        }
        
        return entidadBancariaDAO.update(entidadBancaria);

    }
    
    @Override
    public List<EntidadBancaria> findByNombreEquals(String nombre) throws BusinessException {
        return entidadBancariaDAO.findByNombreEquals(nombre);
    }

    @Override
    public List<EntidadBancaria> findByNombreLike(String nombre) throws BusinessException {
        return entidadBancariaDAO.findByNombreLike(nombre);
    }
    
}
