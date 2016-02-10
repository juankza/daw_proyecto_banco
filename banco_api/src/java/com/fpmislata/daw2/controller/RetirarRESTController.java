package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.Extraccion;
import com.fpmislata.daw2.business.service.RetirarService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.json.JSONTransformer;
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

@Controller
@RequestMapping("/retirar")
public class RetirarRESTController {

    @Autowired
    RetirarService retirarService;
    @Autowired
    JSONTransformer jsonTransformer;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void retirar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonRequest) {
        try {
            Extraccion extraccion = jsonTransformer.toObject(jsonRequest, Extraccion.class);
            retirarService.retirar(extraccion);
            httpServletResponse.getWriter().println(extraccion);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        } catch (BusinessException bex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(RetirarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(RetirarRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
