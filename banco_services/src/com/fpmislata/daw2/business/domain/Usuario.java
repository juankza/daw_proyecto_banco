
package com.fpmislata.daw2.business.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Usuario implements Serializable{
    
    private int idUsuario;
    
    @NotBlank
    @Size(min = 2, max = 255)
    private String nombre;
    
    @NotBlank
    @Size(min = 2, max = 255)
    private String apellidos;
    
    @NotBlank
    @Size(min = 9, max = 9)
    private String dni;
    
    @Email
    @Size(min = 5, max = 255)
    private String email;
    
    @NotBlank
    @Size(min = 3, max = 255)
    private String nickname;
    
    //Quitada validación para hacerla en el servicio.
    @Size(min = 5, max = 255)
    private String contrasena;
    
    @NotNull
    private Rol rol;

    public Usuario() { }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Usuario(int idUsuario, String nombre, String apellidos, String dni, String email, String nickname, String contrasena, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.rol = rol;
    }

   

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
