
package com.fpmislata.daw2.business.domain;

public enum Rol {
    /**
     * Create , Read , Update & Delete Permissions
     */
    ADMIN ,
    
    /**
     * Create , Read , Update & Delete Permissions [RESTRICTED]
     */
    EMPLEADO ,

    /**
     * Read-Only Permissions
     */
    CLIENTE
}
