
package com.fpmislata.daw2.business.domain;

public class Credenciales {
    private String email;
    private String contrasena;
    
    public Credenciales() { }
    
    public Credenciales(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
