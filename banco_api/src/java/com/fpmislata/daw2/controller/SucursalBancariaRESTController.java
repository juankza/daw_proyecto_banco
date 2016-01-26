
package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.SucursalBancaria;
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
@RequestMapping("/sucursalbancaria")
public class SucursalBancariaRESTController {

    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    SucursalBancariaService sucursalBancariaService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<SucursalBancaria> sucursales;
        try {
            sucursales = sucursalBancariaService.findAll();
            if (sucursales != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(sucursales));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (BusinessException bex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
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

    @RequestMapping(value = "/{idSucursalBancaria}", method = RequestMethod.GET, produces = "application/json")
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int idSucursalBancaria) {
        SucursalBancaria sucursalBancaria;
        try {
            sucursalBancaria = sucursalBancariaService.get(idSucursalBancaria);
            if (sucursalBancaria != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(sucursalBancaria));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
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
            Logger.getLogger(SucursalBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonRequest) {
        SucursalBancaria newSucursalBancaria;
        SucursalBancaria insertedSucursalBancaria;

        try {
            newSucursalBancaria = jsonTransformer.toObject(jsonRequest, SucursalBancaria.class);
            insertedSucursalBancaria = sucursalBancariaService.insert(newSucursalBancaria);
            if (insertedSucursalBancaria != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(insertedSucursalBancaria));
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
            Logger.getLogger(SucursalBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @RequestMapping(value = "/{idSucursalBancaria}", method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            boolean isDeleted = sucursalBancariaService.delete(idSucursalBancaria);
            if (isDeleted) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                throw new BusinessException(new BusinessMessage(null, "La sucursal bancaria ya había sido borrada anteriormente."));
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
        }
    }

    @RequestMapping(value = "/{idSucursalBancaria}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria, @RequestBody String jsonRequest) {
        SucursalBancaria newSucursalBancaria;
        SucursalBancaria updatedSucursalBancaria;

        try {
            newSucursalBancaria = jsonTransformer.toObject(jsonRequest, SucursalBancaria.class);
            newSucursalBancaria.setIdSucursalBancaria(idSucursalBancaria);
            updatedSucursalBancaria = sucursalBancariaService.update(newSucursalBancaria);
            if (updatedSucursalBancaria != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(updatedSucursalBancaria));
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                
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
            Logger.getLogger(SucursalBancariaRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
