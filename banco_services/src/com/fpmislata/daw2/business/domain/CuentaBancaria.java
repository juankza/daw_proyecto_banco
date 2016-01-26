
package com.fpmislata.daw2.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CuentaBancaria implements Serializable {

    private int idCuentaBancaria;
    
    @NotNull
    private BigDecimal saldo;
    
    @NotNull
    @Past
    private Date fechaCreacion;
    
    @NotBlank
    @Pattern(regexp="[0-9]{4}",message = "Tiene que contener 4 carácteres numéricos")
    @Size(min = 4, max = 4, message = "Tiene que contener obligatoriamente {max} carácteres")
    private String pin;
    
    @NotBlank
    @Size(min = 2, max = 2, message = "Tiene que contener obligatoriamente {max} carácteres")
    private String digitoControl;
    
    @NotBlank
    @Pattern(regexp = "[0-9]{10}",message = "Solo puede contener 10 carácteres numéricos")
    @Size(min = 10, max = 10, message = "Tiene que contener obligatoriamente {max} carácteres")
    private String numeroCuenta;
    
    @NotNull
    private SucursalBancaria sucursalBancaria;
    
    @NotNull
    private Usuario usuario;

    public CuentaBancaria() { }

    public CuentaBancaria(int idCuentaBancaria, BigDecimal saldo, Date fechaCreacion, String pin, String digitoControl, String numeroCuenta, SucursalBancaria sucursalBancaria, Usuario usuario) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.pin = pin;
        this.digitoControl = digitoControl;
        this.numeroCuenta = numeroCuenta;
        this.sucursalBancaria = sucursalBancaria;
        this.usuario = usuario;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDigitoControl() {
        return digitoControl;
    }

    public void setDigitoControl(String digitoControl) {
        this.digitoControl = digitoControl;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
