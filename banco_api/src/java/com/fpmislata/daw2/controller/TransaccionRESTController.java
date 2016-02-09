package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.CredencialBancoCentral;
import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.business.service.TransaccionService;
import com.fpmislata.daw2.business.service.UrlTransaccionProviderService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
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
@RequestMapping("/transaccion")
public class TransaccionRESTController {

    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    TransaccionService transaccionService;
    @Autowired
    UrlTransaccionProviderService urlTransaccionProviderService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonRequest) {
        /*Transaccion newTransaccion, insertedTransaccion;
        
        try {
            newTransaccion = jsonTransformer.toObject(jsonRequest, Transaccion.class);
            insertedTransaccion = transaccionService.insertaTransaccion(newTransaccion);
            if (insertedTransaccion != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(insertedTransaccion));
            }
        } catch (BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(CuentaBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(CuentaBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

        try {
            Transaccion newTransaccion = jsonTransformer.toObject(jsonRequest, Transaccion.class);
            CredencialBancoCentral credencialBancoCentral = new CredencialBancoCentral(newTransaccion.getCuentaOrigen(), "0000");
      
            //Si la URL se saca por Banco Central, se le hará la petición aquí.
            String urlBancoDestino = urlTransaccionProviderService.getUrlByCodigoEntidad(credencialBancoCentral);
            
            
            //pinto la url pa sabel que todo va bien
            httpServletResponse.getWriter().println(urlBancoDestino);
            
            
            
            
            //TODO: retirar dinero de la cuenta con HTTPClient de Apache
            
            
            
            
            
            
            //TODO: Si el dinero se retira, se realiza el movimiento de ingreso aquí.
            
            
            
            
            
            
            
            
            //Devolvemos 200 y objeto JSON de la transacción realizada
            
            
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
