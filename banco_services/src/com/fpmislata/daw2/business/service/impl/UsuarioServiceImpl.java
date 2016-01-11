package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.Credenciales;
import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.business.service.UsuarioService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.persistence.dao.UsuarioDAO;
import com.fpmislata.daw2.security.PasswordManager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private PasswordManager passwordManager;

    @Override
    public Usuario insert(Usuario usuario) throws BusinessException {
//        List<BusinessMessage> businessMessages;
//        businessMessages = new ArrayList<>();
//        
//        if(usuario.getNombre() == null || usuario.getNombre().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Nombre", "No puede estar vacío"));
//        }
//        
//        if(usuario.getApellidos()== null || usuario.getApellidos().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Apellidos", "No puede estar vacío"));
//        }
//        
//        if(usuario.getEmail() == null || usuario.getEmail().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Email", "No puede estar vacío"));
//        }
//        
//        if(usuario.getNickname() == null || usuario.getNickname().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Nickname", "No puede estar vacío"));
//        }
//        
//        if(usuario.getContrasena() == null || usuario.getContrasena().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Contraseña", "No puede estar vacío"));
//        }
//        
//        validate(businessMessages);

        usuario.setContrasena(passwordManager.encrypt(usuario.getContrasena()));

        return usuarioDAO.insert(usuario);

    }

    @Override
    public Usuario update(Usuario usuario) throws BusinessException {
//        List<BusinessMessage> businessMessages;
//        businessMessages = new ArrayList<>();
//        
//        if(usuario.getNombre() == null || usuario.getNombre().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Nombre", "No puede estar vacío"));
//        }
//        
//        if(usuario.getApellidos()== null || usuario.getApellidos().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Apellidos", "No puede estar vacío"));
//        }
//        
//        if(usuario.getEmail() == null || usuario.getEmail().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Email", "No puede estar vacío"));
//        }
//        
//        if(usuario.getNickname() == null || usuario.getNickname().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Nickname", "No puede estar vacío"));
//        }
//        
//        if(usuario.getContrasena() == null || usuario.getContrasena().trim().equals("")) {
//            businessMessages.add(new BusinessMessage("Contraseña", "No puede estar vacío"));
//        }
//        
//        validate(businessMessages);
        if (usuario.getContrasena() != null) {
            usuario.setContrasena(passwordManager.encrypt(usuario.getContrasena()));
        } else {
            usuario.setContrasena(usuarioDAO.get(usuario.getIdUsuario()).getContrasena());
        }

        return usuarioDAO.update(usuario);

    }

    @Override
    public List<Usuario> findByNombreEquals(String nombre) throws BusinessException {
        List<BusinessMessage> businessMessages;
        businessMessages = new ArrayList<>();

        if (nombre == null || nombre.trim().equals("")) {
            businessMessages.add(new BusinessMessage("Nombre", "No puede estar vacío"));
        }

        validate(businessMessages);

        return usuarioDAO.findByNombreEquals(nombre);
    }

    @Override
    public List<Usuario> findByNombreLike(String nombre) throws BusinessException {
        List<BusinessMessage> businessMessages;
        businessMessages = new ArrayList<>();

        if (nombre == null || nombre.trim().equals("")) {
            businessMessages.add(new BusinessMessage("Nombre", "No puede estar vacío."));
        }

        validate(businessMessages);

        return usuarioDAO.findByNombreLike(nombre);
    }

    @Override
    public Usuario getByEmail(String email) throws BusinessException {
        if (email == null || email.trim().equals("")) {
            throw new RuntimeException("Email no puede estar vacío");
        }

        return usuarioDAO.getByEmail(email);
    }

    @Override
    public Usuario getByCredenciales(Credenciales credenciales) throws BusinessException {
        List<BusinessMessage> businessMessages;
        businessMessages = new ArrayList<>();
        Usuario usuario;

        if (credenciales == null) {
            throw new RuntimeException("Credenciales no puede ser null");
        }

        if (credenciales.getEmail() == null || credenciales.getEmail().trim().equals("")) {
            businessMessages.add(new BusinessMessage("Email", "No puede estar vacío"));
        }

        if (credenciales.getContrasena() == null || credenciales.getContrasena().trim().equals("")) {
            businessMessages.add(new BusinessMessage("Contraseña", "No puede estar vacío"));
        }

        validate(businessMessages);

        usuario = getByEmail(credenciales.getEmail());

        if (usuario != null && passwordManager.check(credenciales.getContrasena(), usuario.getContrasena())) {
            usuario.setContrasena(null);
            return usuario;
        } else {
            return null;
        }
    }

    private void validate(List<BusinessMessage> businessMessages) throws BusinessException {
        if (!businessMessages.isEmpty()) {
            throw new BusinessException(businessMessages);
        }
    }

}
