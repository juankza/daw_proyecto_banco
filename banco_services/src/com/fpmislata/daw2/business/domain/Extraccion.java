package com.fpmislata.daw2.business.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Extraccion implements Serializable {

    private String codigoCuentaCorriente;
    private BigDecimal importe;
    private String token;
    private String concepto;

    public Extraccion() {
        
    }

    public Extraccion(String codigoCuentaCorriente, BigDecimal importe, String token, String concepto) {
        this.codigoCuentaCorriente = codigoCuentaCorriente;
        this.importe = importe;
        this.token = token;
        this.concepto = concepto;
    }

    public String getCodigoCuentaCorriente() {
        return codigoCuentaCorriente;
    }

    public void setCodigoCuentaCorriente(String codigoCuentaCorriente) {
        this.codigoCuentaCorriente = codigoCuentaCorriente;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}
