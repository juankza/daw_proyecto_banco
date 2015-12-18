
package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.Credenciales;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.json.JSONTransformer;
import com.fpmislata.daw2.security.WebSession;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fpmislata.daw2.security.SessionService;

@Controller
@RequestMapping("/session")
public class SessionRESTController {
    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    SessionService loginService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @RequestBody String jsonRequest) {
        try {
            WebSession webSession = loginService.login(httpServletRequest, httpServletResponse, jsonTransformer.toObject(jsonRequest, Credenciales.class));
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonTransformer.toJSON(webSession));
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(SessionRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(SessionRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public void logged(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        WebSession webSession;
        try {
            webSession = loginService.logged(httpServletRequest, httpServletResponse);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonTransformer.toJSON(webSession));
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(SessionRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(SessionRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            loginService.logout(httpServletRequest, httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(SessionRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(SessionRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
