
package com.fpmislata.daw2.security;

import com.fpmislata.daw2.business.domain.Usuario;

import java.util.Date;

public class WebSession {
    private Usuario usuario;
    private Date fecha;
    
    public WebSession() { }
    
    public WebSession(Usuario usuario, Date fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFecha() {
        return fecha;
    }
    
}
