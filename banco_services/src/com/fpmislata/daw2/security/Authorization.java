
package com.fpmislata.daw2.security;

import com.fpmislata.daw2.business.domain.Usuario;

public interface Authorization {
    boolean isAuthorizedURL(Usuario usuario, String url, HTTPMethod httpmethod);
}
