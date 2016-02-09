
package com.fpmislata.daw2.business.service;

import com.fpmislata.daw2.business.domain.CredencialBancoCentral;
import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.core.exception.BusinessException;

public interface UrlTransaccionProviderService extends GenericService<Transaccion,Integer>{
    public String getUrlByCodigoEntidad(CredencialBancoCentral credencialBancoCentral) throws BusinessException;
}
