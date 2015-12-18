
package com.fpmislata.daw2.business.domain;

import java.util.Date;

public class EntidadBancaria {
    private int idEntidadBancaria;
    private String nombre;
    private String codigoEntidadBancaria;
    private Date fechaCreacion;
    private String direccion;
    private String cif;
    
    public EntidadBancaria() { }

    public EntidadBancaria(int idEntidadBancaria, String nombre, String codigoEntidadBancaria, Date fechaCreacion, String direccion, String cif) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidadBancaria = codigoEntidadBancaria;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.cif = cif;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }
    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }
    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
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

    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }

}
