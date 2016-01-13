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
 * @author Reim0n
 */
public class CuentaBancaria implements Serializable {

    private int idCuenta;
    @NotNull
    private BigDecimal saldo;
    @NotNull
    @Past
    private Date fechaCreacion;
    @NotBlank
    @Size(min = 4, max = 4)
    private String pin;
    @NotBlank
    @Size(min = 2, max = 2)
    private String digitoControl;
    @NotBlank
    @Size(min = 10, max = 10)
    private String numeroCuenta;
    @NotNull
    private int idSucursalBancaria;
    @NotNull
    private int idUsuario;

    public CuentaBancaria() {
    }

    public CuentaBancaria(BigDecimal saldo, Date fechaCreacion, String pin, String digitoControl, String numeroCuenta, int idSucursalBancaria, int idUsuario) {
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.pin = pin;
        this.digitoControl = digitoControl;
        this.numeroCuenta = numeroCuenta;
        this.idSucursalBancaria = idSucursalBancaria;
        this.idUsuario = idUsuario;
    }

    public CuentaBancaria(int idCuenta, BigDecimal saldo, Date fechaCreacion, String pin, String digitoControl, String numeroCuenta, int idSucursalBancaria, int idUsuario) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.pin = pin;
        this.digitoControl = digitoControl;
        this.numeroCuenta = numeroCuenta;
        this.idSucursalBancaria = idSucursalBancaria;
        this.idUsuario = idUsuario;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
