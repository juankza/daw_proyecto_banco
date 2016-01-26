
package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.MovimientoBancario;
import com.fpmislata.daw2.business.service.MovimientoBancarioService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.json.JSONTransformer;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/movimientobancario")

public class MovimientoBancarioRESTController {
    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    MovimientoBancarioService movimientoBancarioService;
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        List<MovimientoBancario> movimientos;
        try{
            movimientos = movimientoBancarioService.findAll();
            if (movimientos != null){
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(movimientos));
            }else{
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }catch(BusinessException bex){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try{
              httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(CuentaBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(SucursalBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/{idMovimientoBancario}", method = RequestMethod.GET, produces = "application/json")
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int idMovimientoBancario){
        MovimientoBancario movimientoBancario;
        try{
            movimientoBancario = movimientoBancarioService.get(idMovimientoBancario);
            if (movimientoBancario != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(movimientoBancario));
            }else{
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }catch (BusinessException bex) {
            try{
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            }catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(CuentaBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (IOException ex){
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(SucursalBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonRequest){
        MovimientoBancario newMovimientoBancario;
        MovimientoBancario insertedMovimientoBancario;
        
        try{
            newMovimientoBancario = jsonTransformer.toObject(jsonRequest, MovimientoBancario.class);
            insertedMovimientoBancario = movimientoBancarioService.insert(newMovimientoBancario);
            
            if (insertedMovimientoBancario != null){
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(insertedMovimientoBancario));
            }
        }catch(BusinessException bex){
            try{
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            }catch(IOException ex){
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(CuentaBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(SucursalBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
