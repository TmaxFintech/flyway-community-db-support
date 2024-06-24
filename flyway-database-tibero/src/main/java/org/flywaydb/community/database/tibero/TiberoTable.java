package org.flywaydb.community.database.tibero;

import java.sql.SQLException;
import org.flywaydb.core.internal.database.InsertRowLock;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;

/**
 * Flyway가 작동하는 데이터베이스 부분에 대한 Flyway의 내부 표현을 구성합니다.
 */
public class TiberoTable extends Table<TiberoDatabase, TiberoSchema> {
    private final InsertRowLock insertRowLock;

    /**
     * @param jdbcTemplate The JDBC template for communicating with the DB.
     * @param database     The database-specific support.
     * @param schema       The schema this table lives in.
     * @param name         The name of the table.
     */
    public TiberoTable(JdbcTemplate jdbcTemplate, TiberoDatabase database, TiberoSchema schema, String name) {
        super(jdbcTemplate, database, schema, name);
        this.insertRowLock = new InsertRowLock(jdbcTemplate);
    }

    @Override
    protected void doDrop() throws SQLException {
    }

    @Override
    protected boolean doExists() throws SQLException {
        return true;
    }

    @Override
    protected void doLock() throws SQLException {
    }

    @Override
    protected void doUnlock() throws SQLException {
    }

}
