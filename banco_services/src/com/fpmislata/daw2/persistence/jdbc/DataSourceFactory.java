
package com.fpmislata.daw2.persistence.jdbc;

import javax.sql.DataSource;

public interface DataSourceFactory {
    public DataSource getDataSource();
}
