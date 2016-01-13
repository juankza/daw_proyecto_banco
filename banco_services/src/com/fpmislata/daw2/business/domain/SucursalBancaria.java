/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.domain;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Lliurex
 */
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
    @Size(min = 3, max = 30)
    private String telefono;
    @NotNull
    private int idEntidadBancaria;

    public SucursalBancaria() {
    }

    public SucursalBancaria(int idSucursalBancaria, String codigoSucursalBancaria, Date fechaCreacion, String direccion, String telefono) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.codigoSucursalBancaria = codigoSucursalBancaria;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public SucursalBancaria(String codigoSucursalBancaria, Date fechaCreacion, String direccion, String telefono) {
        this.codigoSucursalBancaria = codigoSucursalBancaria;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
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

}
