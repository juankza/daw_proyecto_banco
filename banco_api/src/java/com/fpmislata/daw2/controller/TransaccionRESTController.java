package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.business.service.TransaccionService;
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
import com.fpmislata.daw2.business.service.BancoCentralService;

@Controller
@RequestMapping("/transaccion")
public class TransaccionRESTController {

    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    TransaccionService transaccionService;
    @Autowired
    BancoCentralService urlTransaccionProviderService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonRequest) {
        try {
            Transaccion newTransaccion = jsonTransformer.toObject(jsonRequest, Transaccion.class);
            Transaccion insertedTransaccion = transaccionService.insertarTransaccion(newTransaccion);
            httpServletResponse.getWriter().println(jsonTransformer.toJSON(insertedTransaccion));
        } catch (BusinessException bex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(TransaccionRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(TransaccionRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
