package org.flywaydb.community.database.tibero;

import java.sql.SQLException;
import org.flywaydb.core.internal.database.base.Schema;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;

/**
 * Add overrides for FooSchema to customize it to fit the SQL dialect your database uses
 */
public class TiberoSchema extends Schema<TiberoDatabase, TiberoTable> {

    public TiberoSchema(JdbcTemplate jdbcTemplate, TiberoDatabase database, String name) {
        super(jdbcTemplate, database, name);
    }

    /**
     * to query whether the schema described exists in the database
     * @return
     * @throws SQLException
     */
    @Override
    protected boolean doExists() throws SQLException {
        return true;
    }

    /**
     * to query whether the schema contains any sub-objects eg. tables, views, procedures.
     */
    @Override
    protected boolean doEmpty() throws SQLException {
        return true;
    }

    /**
     * to create the schema in the database
     */
    @Override
    protected void doCreate() throws SQLException {
    }

    /**
     * to drop the schema in the database
     */
    @Override
    protected void doDrop() throws SQLException {
    }

    /**
     * to drop all the objects that exist in the schema
     */
    @Override
    protected void doClean() throws SQLException {
    }

    /**
     *  to query for all the tables in the schema and return a populated array of FooTable objects
     */
    @Override
    protected TiberoTable[] doAllTables() throws SQLException {
        return new TiberoTable[1];
    }

    /**
     * to return a FooTable object for the given name
     */
    @Override
    public Table getTable(String tableName) {
        return new TiberoTable(jdbcTemplate, database, this, tableName);
    }
}
