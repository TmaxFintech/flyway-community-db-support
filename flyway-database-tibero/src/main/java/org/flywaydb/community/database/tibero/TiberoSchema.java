package org.flywaydb.community.database.tibero;

import java.sql.SQLException;
import org.flywaydb.core.internal.database.base.Schema;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;

/**
 * Tibero implementation of Schema
 */
public class TiberoSchema extends Schema<TiberoDatabase, TiberoTable> {

    /**
     * Creates a new Tibero schema
     *
     * @param jdbcTemplate The Jdbc Template for communicating with the DB.
     * @param database The database-specific support.
     * @param name The name of the schema.
     */
    public TiberoSchema(JdbcTemplate jdbcTemplate, TiberoDatabase database, String name) {
        super(jdbcTemplate, database, name);
    }

    /**
     * TODO: Tibero에 맞춰서 쿼리 변경 필요
     * to query whether the schema described exists in the database
     * @return
     * @throws SQLException
     */
    @Override
    protected boolean doExists() throws SQLException {
        return database.queryReturnsRows("SELECT * FROM ALL_USERS WHERE USERNAME = ?", name);
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

    /**
     * Checks whether the schema is system, i.e. Oracle-maintained, or not.
     *
     * @return {@code true} if it is system, {@code false} if not.
     */
    public boolean isSystem() throws SQLException {
//        return database.getSystemSchemas().contains(name);

        return true;
    }

    /**
     * Checks whether this schema is default for the current user.
     *
     * @return {@code true} if it is default, {@code false} if not.
     */
    boolean isDefaultSchemaForUser() throws SQLException {
        return name.equals(database.doGetCurrentUser());
    }
}
