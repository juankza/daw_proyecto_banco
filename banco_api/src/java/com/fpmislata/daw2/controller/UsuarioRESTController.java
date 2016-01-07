
package com.fpmislata.daw2.controller;

import com.fpmislata.daw2.business.domain.Usuario;
import com.fpmislata.daw2.business.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioRESTController {
    @Autowired
    JSONTransformer jsonTransformer;
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET, produces = "application/json")
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("idUsuario") int idUsuario) {
        Usuario usuario;
        try {
            usuario = usuarioService.get(idUsuario);
            if(usuario != null) {
                usuario.setContrasena(null);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(usuario));
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
                Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @RequestBody String jsonRequest) {
        Usuario newUsuario;
        Usuario insertedUsuario;
        try {
            newUsuario = jsonTransformer.toObject(jsonRequest, Usuario.class);
            insertedUsuario = usuarioService.insert(newUsuario);
            if(insertedUsuario != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(insertedUsuario));
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
                Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("idUsuario") int idUsuario, @RequestBody String jsonRequest) {
        Usuario newUsuario;
        Usuario updatedUsuario;
        try {
            newUsuario = jsonTransformer.toObject(jsonRequest, Usuario.class);
            newUsuario.setIdUsuario(idUsuario);
            updatedUsuario = usuarioService.update(newUsuario);
            if(updatedUsuario != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(updatedUsuario));
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
                Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("idUsuario") int idUsuario) {
        try {
            boolean isDeleted = usuarioService.delete(idUsuario);
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
                Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Usuario> usuarios;
        try {
            usuarios = usuarioService.findAll();
            if(usuarios != null && !usuarios.isEmpty()) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(usuarios));
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
                Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // TODO UPGRADE: Double type of search by name (Equals & Like).
    @RequestMapping(value = "/search/{nombreUsuario}", method = RequestMethod.GET, produces = "application/json")
    public void findByName(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
    @PathVariable("nombreUsuario") String nombreUsuario) {
        List<Usuario> usuarios;
        try {
            usuarios = usuarioService.findByNombreLike(nombreUsuario);
            if(usuarios != null && !usuarios.isEmpty()) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonTransformer.toJSON(usuarios));
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
                Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(UsuarioRESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
