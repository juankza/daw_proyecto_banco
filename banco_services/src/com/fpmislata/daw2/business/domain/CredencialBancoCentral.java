package com.fpmislata.daw2.business.domain;

import java.io.Serializable;

public class CredencialBancoCentral implements Serializable{
    private String codigoCuentaCorriente;
    private String pin;
    private String codigoEntidadBancaria;

    public CredencialBancoCentral(String codigoCuentaCorriente, String pin, String codigoEntidadBancaria) {
        this.codigoCuentaCorriente = codigoCuentaCorriente;
        this.pin = pin;
        this.codigoEntidadBancaria = codigoEntidadBancaria;
    }

    public CredencialBancoCentral() {
    }

    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }

    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
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
