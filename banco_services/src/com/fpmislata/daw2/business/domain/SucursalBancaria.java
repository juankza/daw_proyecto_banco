
package com.fpmislata.daw2.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SucursalBancaria implements Serializable {

    private int idSucursalBancaria;
    
    @NotBlank
    @Size(min = 4, max = 4, message = "Tiene que contener obligatoriamente {max} carácteres")
    private String codigoSucursalBancaria;
    
    @NotNull
    @Past
    private Date fechaCreacion;
    
    @NotBlank
    @Size(min = 3, max = 255)
    private String direccion;
    @NotBlank
    @Size(min = 3, max = 30)
    private String telefono;
    
    @NotNull
    private EntidadBancaria entidadBancaria;

    public SucursalBancaria() { }

    public SucursalBancaria(int idSucursalBancaria, String codigoSucursalBancaria, Date fechaCreacion, String direccion, String telefono, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.codigoSucursalBancaria = codigoSucursalBancaria;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.entidadBancaria = entidadBancaria;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getCodigoSucursalBancaria() {
        return codigoSucursalBancaria;
    }

    public void setCodigoSucursalBancaria(String codigoSucursalBancaria) {
        this.codigoSucursalBancaria = codigoSucursalBancaria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

}
