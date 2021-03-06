
package com.fpmislata.daw2.security.impl;

import com.fpmislata.daw2.business.domain.Rol;
import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.security.Authorization;
import com.fpmislata.daw2.security.HTTPMethod;

public class AuthorizationImplDummy implements Authorization {

    private final String URL_API = "/api";
    private final String URL_SESSION = URL_API + "/session";
    
    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, HTTPMethod httpmethod) {
        if(url.equalsIgnoreCase(URL_API) || url.equalsIgnoreCase(URL_SESSION)) {
            return true;
        } else {
            if(usuario != null) {
                if(usuario.getRol() == Rol.ADMIN || usuario.getRol() == Rol.EMPLEADO) {
                    return true;
                } else if(usuario.getRol() == Rol.CLIENTE) {
                    return (httpmethod == HTTPMethod.GET);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
