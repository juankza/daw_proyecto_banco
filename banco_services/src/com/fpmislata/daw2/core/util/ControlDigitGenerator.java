
package com.fpmislata.daw2.core.util;

public class ControlDigitGenerator {
    public static String generateControlDigit(String codigoEntidadBancaria,String codigoSucursalBancaria,String codigoCuentaBancaria) {
    int dc1=0;
 
    dc1=dc1+Integer.parseInt(codigoEntidadBancaria.substring(0,1))*4;
    dc1=dc1+Integer.parseInt(codigoEntidadBancaria.substring(1,2))*8;
    dc1=dc1+Integer.parseInt(codigoEntidadBancaria.substring(2,3))*5;
    dc1=dc1+Integer.parseInt(codigoEntidadBancaria.substring(3,4))*10;
    dc1=dc1+Integer.parseInt(codigoSucursalBancaria.substring(0,1))*9;
    dc1=dc1+Integer.parseInt(codigoSucursalBancaria.substring(1,2))*7;
    dc1=dc1+Integer.parseInt(codigoSucursalBancaria.substring(2,3))*3;
    dc1=dc1+Integer.parseInt(codigoSucursalBancaria.substring(3,4))*6;   
 
    dc1=dc1 %11;
    dc1=11-dc1;
    if (dc1==10) {
        dc1=1;
    }
    if (dc1==11) {
        dc1=0;
    }    
 
    int dc2=0;
 
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(0,1))*1;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(1,2))*2;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(2,3))*4;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(3,4))*8;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(4,5))*5;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(5,6))*10;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(6,7))*9;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(7,8))*7;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(8,9))*3;
    dc2=dc2+Integer.parseInt(codigoCuentaBancaria.substring(9,10))*6;    
 
 
    dc2=dc2 %11;
    dc2=11-dc2;
    if (dc2==10) {
        dc2=1;
    }
    if (dc2==11) {
        dc2=0;
    }    
 
    String dc=String.valueOf(dc1)+String.valueOf(dc2);
 
    return dc;
}
}
