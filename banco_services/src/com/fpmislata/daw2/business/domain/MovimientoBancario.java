    
package com.fpmislata.daw2.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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
    private BigDecimal saldo;
    
    @NotNull
    @Past
    private Date fecha;
    
    @NotNull
    private CuentaBancaria cuentaBancaria;

    public MovimientoBancario() { }

    public MovimientoBancario(TipoMovimientoBancario tipoMovimientoBancario, String concepto, BigDecimal cantidad, BigDecimal saldo, Date fecha, CuentaBancaria cuentaBancaria) {
        this.tipoMovimientoBancario = tipoMovimientoBancario;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.saldo = saldo;
        this.fecha = fecha;
        this.cuentaBancaria = cuentaBancaria;
    }
    
    public MovimientoBancario(int idMovimientoBancario, TipoMovimientoBancario tipoMovimientoBancario, String concepto, BigDecimal cantidad, BigDecimal saldo, Date fecha, CuentaBancaria cuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.tipoMovimientoBancario = tipoMovimientoBancario;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.saldo = saldo;
        this.fecha = fecha;
        this.cuentaBancaria = cuentaBancaria;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

}
