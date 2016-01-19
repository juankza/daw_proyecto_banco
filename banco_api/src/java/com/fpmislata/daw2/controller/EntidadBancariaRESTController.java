
package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.EntidadBancaria;
import com.fpmislata.daw2.business.domain.SucursalBancaria;
import com.fpmislata.daw2.business.service.EntidadBancariaService;
import com.fpmislata.daw2.business.service.SucursalBancariaService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
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
@RequestMapping("/entidadbancaria")
public class EntidadBancariaRESTController {
    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    EntidadBancariaService entidadBancariaService;
    
    @Autowired
    SucursalBancariaService sucursalBancariaService;
    
    @RequestMapping(value = "/{idEntidadBancaria}", method = RequestMethod.GET, produces = "application/json")
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        EntidadBancaria entidadBancaria;
        try {
            entidadBancaria = entidadBancariaService.get(idEntidadBancaria);
            if(entidadBancaria != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(entidadBancaria));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @RequestBody String jsonRequest) {
        EntidadBancaria newEntidadBancaria;
        EntidadBancaria insertedEntidad;
        try {
            newEntidadBancaria = jsonTransformer.toObject(jsonRequest, EntidadBancaria.class);
            insertedEntidad = entidadBancariaService.insert(newEntidadBancaria);
            if(insertedEntidad != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(insertedEntidad));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/{idEntidadBancaria}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("idEntidadBancaria") int idEntidadBancaria, @RequestBody String jsonRequest) {
        EntidadBancaria newEntidadBancaria;
        EntidadBancaria updatedEntidadBancaria;
        try {
            newEntidadBancaria = jsonTransformer.toObject(jsonRequest, EntidadBancaria.class);
            newEntidadBancaria.setIdEntidadBancaria(idEntidadBancaria);
            updatedEntidadBancaria = entidadBancariaService.update(newEntidadBancaria);
            if(updatedEntidadBancaria != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(updatedEntidadBancaria));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/{idEntidadBancaria}", method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            boolean isDeleted = entidadBancariaService.delete(idEntidadBancaria);
            if(isDeleted) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                throw new BusinessException(new BusinessMessage(null, "Error: La EntidadBancaria ya había sido borrada anteriormente."));
            }
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<EntidadBancaria> entidadesBancarias;
        try {
            entidadesBancarias = entidadBancariaService.findAll();
            if(entidadesBancarias != null && !entidadesBancarias.isEmpty()) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(entidadesBancarias));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public void findByName(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<EntidadBancaria> entidadesBancarias;
        String nombreEntidadBancaria;
        String where;
        try {
            nombreEntidadBancaria = httpServletRequest.getParameter("nombre");
            where = httpServletRequest.getParameter("where");
            
            if(where != null) {
                if(where.trim().equals("eq")) {
                    entidadesBancarias = entidadBancariaService.findByNombreEquals(nombreEntidadBancaria);
                } else {
                    entidadesBancarias = entidadBancariaService.findByNombreLike(nombreEntidadBancaria);
                }
            } else {
                entidadesBancarias = entidadBancariaService.findByNombreLike(nombreEntidadBancaria);
            }
            
            if(entidadesBancarias != null && !entidadesBancarias.isEmpty()) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(entidadesBancarias));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch(BusinessException bex) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/{idEntidadBancaria}/sucursalbancaria")
    public void getSucursalesByEntidad(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int idEntidadBancaria){
        List<SucursalBancaria> sucursalesBancarias;
        
        try {
            sucursalesBancarias = sucursalBancariaService.getSucursalesByEntidad(idEntidadBancaria);
            if (sucursalesBancarias != null && !sucursalesBancarias.isEmpty()) {
                    httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(sucursalesBancarias));
            }else{
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (BusinessException bex) {
               httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(bex.getBusinessMessages()));
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(EntidadBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
