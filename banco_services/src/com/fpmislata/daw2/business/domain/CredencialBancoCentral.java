package com.fpmislata.daw2.business.domain;

import java.io.Serializable;

public class CredencialBancoCentral implements Serializable{
    private String codigoCuentaCorriente;
    private String pin;

    public CredencialBancoCentral(String codigoCuentaCorriente, String pin) {
        this.codigoCuentaCorriente = codigoCuentaCorriente;
        this.pin = pin;
    }

    public String getCodigoCuentaCorriente() {
        return codigoCuentaCorriente;
    }

    public void setCodigoCuentaCorriente(String codigoCuentaCorriente) {
        this.codigoCuentaCorriente = codigoCuentaCorriente;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    
}
