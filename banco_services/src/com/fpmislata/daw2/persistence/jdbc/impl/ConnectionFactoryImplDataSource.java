
package com.fpmislata.daw2.persistence.jdbc.impl;


import com.fpmislata.daw2.persistence.jdbc.ConnectionFactory;
import com.fpmislata.daw2.persistence.jdbc.DataSourceFactory;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {
    @Autowired
    DataSourceFactory dataSourceFactory;
    
    @Override
    public Connection getConnection() {
        try {
            return dataSourceFactory.getDataSource().getConnection();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
