package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.CredencialBancoAjeno;
import com.fpmislata.daw2.business.domain.CredencialBancoCentral;
import com.fpmislata.daw2.business.domain.Transaccion;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.business.service.BancoCentralService;

public class BancoCentralServiceImplDummy extends GenericServiceImpl<Transaccion,Integer> implements BancoCentralService{
    private final String URL_GRUPO_1 = "http://localhost:8084/api/retirar";
    private final String URL_GRUPO_2 = "http://localhost:8084/api/retirar";
    private final String URL_GRUPO_3 = "http://localhost:8084/api/retirar";
    //private final String URL_GRUPO_3 = "http://banco-samuvl.rhcloud.com/banktastic-banco-api/api/retirar";
    @Override
    public CredencialBancoAjeno getUrlByNumeroCuenta(CredencialBancoCentral credencialBancoCentral) throws BusinessException {
        if (!credencialBancoCentral.getCodigoEntidadBancaria().equals("0049")) {
            throw new BusinessException(new BusinessMessage("Banco Central","La entidad bancaria no figura en este Banco Central."));
        }
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
                return new CredencialBancoAjeno(URL_GRUPO_1,"1111"); //HAY QUE CAMBIAR LOS PIN SEGÚN EL CONSENSO QUE HAGAMOS EN CLASE
            }else if(codigoEntidadNumerico >= 1000 && codigoEntidadNumerico <= 1999){
                return new CredencialBancoAjeno(URL_GRUPO_2,"1111");
            }else if(codigoEntidadNumerico >= 2000 && codigoEntidadNumerico <= 2999){
                return new CredencialBancoAjeno(URL_GRUPO_3,"1111");
            }else{
                throw new BusinessException(new BusinessMessage("CodigoEntidadBancaria","El código de entidad no corresponde a un banco nacional."));
            }
        } catch (NumberFormatException ex) {
            throw new BusinessException(new BusinessMessage("CodigoEntidadBancaria","El código de la entidad bancaria es inválido."));
        }
       
        
    }

    

}
