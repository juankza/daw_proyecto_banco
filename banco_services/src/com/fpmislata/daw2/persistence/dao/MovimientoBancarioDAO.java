
package com.fpmislata.daw2.persistence.dao;

import com.fpmislata.daw2.business.domain.MovimientoBancario;
import java.util.List;

public interface MovimientoBancarioDAO extends GenericDAO<MovimientoBancario, Integer>{
    public List<MovimientoBancario> getByCuentaBancaria(int idCuentaBancaria);
}
