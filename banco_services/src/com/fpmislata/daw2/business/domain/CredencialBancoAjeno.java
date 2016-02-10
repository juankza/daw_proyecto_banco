package com.fpmislata.daw2.business.domain;

import java.io.Serializable;

public class CredencialBancoAjeno implements Serializable {
private String url;
private String token;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CredencialBancoAjeno(String url, String token) {
        this.url = url;
        this.token = token;
    }


}
