
package com.fpmislata.daw2.persistence.jdbc;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection getConnection();
    void close(Connection connection);
}
