/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.business.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Lliurex
 */
public class MovimientoBancario implements Serializable {

    private int idMovimientoBancario;
    @NotNull
    private TipoMovimientoBancario tipoMovimientoBancario;
    @NotBlank
    @Size(min = 3, max = 255)
    private String concepto;
    @NotNull
    private BigDecimal cantidad;
    @NotNull
    @Past
    private Date fecha;
    @NotNull
    private int idCuentaBancaria;

    public MovimientoBancario(TipoMovimientoBancario tipoMovimientoBancario, String concepto, BigDecimal cantidad, Date fecha, int idCuentaBancaria) {
        this.tipoMovimientoBancario = tipoMovimientoBancario;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public MovimientoBancario() {
    }

    public MovimientoBancario(int idMovimientoBancario, TipoMovimientoBancario tipoMovimientoBancario, String concepto, BigDecimal cantidad, Date fecha, int idCuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.tipoMovimientoBancario = tipoMovimientoBancario;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public TipoMovimientoBancario getTipoMovimientoBancario() {
        return tipoMovimientoBancario;
    }

    public void setTipoMovimientoBancario(TipoMovimientoBancario tipoMovimientoBancario) {
        this.tipoMovimientoBancario = tipoMovimientoBancario;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

}
