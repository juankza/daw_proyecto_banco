
package com.fpmislata.daw2.business.domain;

import java.math.BigDecimal;

public class Transaccion {
    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal importe;
    private String concepto;
    private String pin;
    
    public Transaccion() { }
    
    public Transaccion(String cuentaOrigen, String cuentaDestino, BigDecimal importe, String concepto, String pin) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.importe = importe;
        this.concepto = concepto;
        this.pin = pin;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }
    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getImporte() {
        return importe;
    }
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    
}
