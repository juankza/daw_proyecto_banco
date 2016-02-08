
package com.fpmislata.daw2.security.impl;

import com.fpmislata.daw2.business.domain.Rol;
import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.security.Authorization;
import com.fpmislata.daw2.security.HTTPMethod;

public class AuthorizationImplDummy implements Authorization {

    private final String URL_API = "/api";
    private final String URL_SESSION = URL_API + "/session";
    private final String URL_TRANSACCION = URL_API + "/transaccion";
    
    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, HTTPMethod httpmethod) {
        if(url.equals(URL_API) || url.equals(URL_API + "/") || url.equals(URL_SESSION) || url.equals(URL_SESSION + "/") || url.equals(URL_TRANSACCION)) {
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
