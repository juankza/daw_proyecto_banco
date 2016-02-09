package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CredencialBancoCentral;
import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.business.service.UrlTransaccionProviderService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;

public class UrlTransaccionProviderServiceImpl extends GenericServiceImpl<Transaccion,Integer> implements UrlTransaccionProviderService{
    private final String URL_GRUPO_1 = "http://localhost:8084/api/transaccion1";
    private final String URL_GRUPO_2 = "http://localhost:8084/api/transaccion2";
    private final String URL_GRUPO_3 = "http://localhost:8084/api/transaccion3";
    @Override
    public String getUrlByCodigoEntidad(CredencialBancoCentral credencialBancoCentral) throws BusinessException {
        if(credencialBancoCentral.getCodigoCuentaCorriente().length() != 20 || !credencialBancoCentral.getCodigoCuentaCorriente().matches("[0-9]+")) {
            throw new BusinessException(new BusinessMessage("Cuenta Origen","Introduce los datos de la cuenta origen correctamente."));
        }
        String codigoCuentaCorriente = credencialBancoCentral.getCodigoCuentaCorriente();
        String codigoEntidadBancaria = codigoCuentaCorriente.substring(0,4);
        if (!credencialBancoCentral.getPin().equals("0000")) {
            throw new BusinessException(new BusinessMessage("Pin","El pin del banco central es incorrecto."));
        }
        try {
            int codigoEntidadNumerico = Integer.parseInt(codigoEntidadBancaria);
            if (codigoEntidadNumerico > 0 && codigoEntidadNumerico < 1000) {
                return URL_GRUPO_1;
            }else if(codigoEntidadNumerico >= 1000 && codigoEntidadNumerico <= 1999){
                return URL_GRUPO_2;
            }else if(codigoEntidadNumerico >= 2000 && codigoEntidadNumerico <= 2999){
                return URL_GRUPO_3;
            }else{
                throw new BusinessException(new BusinessMessage("CodigoEntidadBancaria","El código de entidad no corresponde a un banco nacional."));
            }
        } catch (NumberFormatException ex) {
            throw new BusinessException(new BusinessMessage("CodigoEntidadBancaria","El código de la entidad bancaria es inválido."));
        }
        
        
    }

    

}
