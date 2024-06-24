package org.flywaydb.community.database.tibero;

import java.sql.Connection;
import java.sql.SQLException;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.internal.database.base.Database;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcConnectionFactory;
import org.flywaydb.core.internal.jdbc.StatementInterceptor;

/**
 * Flyway가 작동하는 데이터베이스 부분에 대한 Flyway의 내부 표현을 구성합니다.
 * Implement methods for FooDatabase to customize it to fit the SQL conventions of your database
 * */
public class TiberoDatabase extends Database<TiberoConnection> {
    public TiberoDatabase(Configuration configuration, JdbcConnectionFactory jdbcConnectionFactory, StatementInterceptor statementInterceptor) {
        super(configuration, jdbcConnectionFactory, statementInterceptor);
    }

    /**
     * to return a new FooConnection
     */
    @Override
    protected TiberoConnection doGetConnection(Connection connection) {
        return new TiberoConnection(this, connection);
    }

    @Override
    protected String doGetCurrentUser() throws SQLException {
        return "";
    }

    /**
     *  to determine which versions of your database will be supported by Flyway. During development, you can leave this as a no-op.
     */
    @Override
    public void ensureSupported(Configuration configuration) {
    }

    /**
     * to return whether the database can support executing DDL statements inside a transaction or not.
     */
    @Override
    public boolean supportsDdlTransactions() {
        return false;
    }

    /**
     *  to return string representations of the Boolean values as used in your database's dialect of SQL.
     *  Typically these are "true" and "false", but could be, for example, "1" and "0"
     */
    @Override
    public String getBooleanTrue() {
        return "TRUE";
    }

    /**
     *  to return string representations of the Boolean values as used in your database's dialect of SQL.
     *  Typically these are "true" and "false", but could be, for example, "1" and "0"
     */
    @Override
    public String getBooleanFalse() {
        return "FALSE";
    }

    /**
     * to return true if the database uses a catalog to represent a single schema (eg. MySQL, SQLite);
     * false if a catalog is a collection of schemas.
     */
    @Override
    public boolean catalogIsSchema() {
        return false;
    }

    /**
     * You may need to provide your own implementations of these methods:
     *
     * if your database can't support an empty string in the description column of the history table verbatim
     * (eg. Oracle implicitly converts it to NULL), override this to return false.
     */
    @Override
    public boolean supportsMultiStatementTransactions() {
        return false;
    }

    @Override
    public boolean useSingleConnection() {
        return true;
    }

    /**
     * You may need to provide your own implementations of these methods:
     * to return an escaped version of an identifier for use in SQL.
     * Typically this is the provided value with a double-quote added either side,
     * but could be, for example, square brackets either side as in SQL Server.
     */
    @Override
    public String doQuote(String identifier) {
        return "";
    }

    @Override
    protected String getOpenQuote() {
        return "";
    }

    @Override
    protected String getCloseQuote() {
        return "";
    }

    @Override
    public String getEscapedQuote() {
        return "";
    }

    /**
     * to return SQL appropriate for your database to create the schema history table.
     * Refer to an existing database type to see the column types needed.
     * The table name will be provided by the table argument.
     * If the baseline argument is true, this method should also insert a row for the baseline migration.
     */
    @Override
    public String getRawCreateScript(Table table, boolean baseline) {
        return "";
    }

    /**
     * You may need to provide your own implementations of these methods:
     *
     * to return SQL appropriate to insert a row into the history table with nine parameter values (corresponding to the table columns in order)
     */
    @Override
    public String getInsertStatement(Table table) {
        // Explicitly set installed_on to CURRENT_TIMESTAMP().
        return "";
    }
}
