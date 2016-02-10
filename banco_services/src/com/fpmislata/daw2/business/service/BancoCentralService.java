
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.CredencialBancoAjeno;
import com.fpmislata.daw2.business.domain.CredencialBancoCentral;
import com.fpmislata.daw2.core.exception.BusinessException;

public interface BancoCentralService{
    public CredencialBancoAjeno getUrlByNumeroCuenta(CredencialBancoCentral credencialBancoCentral) throws BusinessException;
}
