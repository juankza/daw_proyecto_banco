
package com.fpmislata.daw2.business.domain;

public enum Role {
    /**
     * Create , Read , Update & Delete Permissions
     */
    ROOT ,
    
    /**
     * Create , Read , Update & Delete Permissions [RESTRICTED]
     */
    ADMIN ,
    
    /**
     * Create , Read , Update & Delete Permissions [RESTRICTED]
     */
    USER ,

    /**
     * Read-Only Permissions
     */
    GUEST
}
