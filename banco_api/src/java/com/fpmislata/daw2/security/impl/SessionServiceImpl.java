
package com.fpmislata.daw2.security.impl;

import com.fpmislata.daw2.business.domain.Credenciales;
import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.business.service.UsuarioService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.security.WebSession;
import com.fpmislata.daw2.security.WebSessionProvider;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import com.fpmislata.daw2.security.SessionService;

public class SessionServiceImpl implements SessionService {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    WebSessionProvider webSessionProvider;

    @Override
    public WebSession login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Credenciales credenciales)
    throws BusinessException {
        Usuario usuario;
        
        usuario = usuarioService.getByCredenciales(credenciales);
        if(usuario != null) {
            webSessionProvider.setWebSession(httpServletRequest, httpServletResponse, new WebSession(usuario, new Date()));
        } else {
            throw new BusinessException(new BusinessMessage(null, "Email y/o Contraseña incorrectos"));
        }
        
        return webSessionProvider.getWebSession(httpServletRequest, httpServletResponse);
    }

    @Override
    public WebSession logged(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BusinessException {
        WebSession webSession;
        
        webSession = webSessionProvider.getWebSession(httpServletRequest, httpServletResponse);
        if(webSession != null) {
            return webSession;
        } else {
            throw new BusinessException(new BusinessMessage(null, "Sessión no iniciada"));
        }
    }
    
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BusinessException {
        webSessionProvider.setWebSession(httpServletRequest, httpServletResponse, null);
    }

}
