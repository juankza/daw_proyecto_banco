
package com.fpmislata.daw2.security;

import com.fpmislata.daw2.business.domain.Credenciales;
import com.fpmislata.daw2.core.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SessionService {
    WebSession login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Credenciales credenciales)
        throws BusinessException;
    WebSession logged(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws BusinessException;
    void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws BusinessException;
}
