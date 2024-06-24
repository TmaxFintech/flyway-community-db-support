package org.flywaydb.community.database.tibero;

import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.internal.parser.Parser;
import org.flywaydb.core.internal.parser.ParsingContext;

/**
 * You may want to add overrides for FooParser to customize it to fit the SQL dialect your database uses
 */
public class TiberoParser extends Parser {
    protected TiberoParser(Configuration configuration, ParsingContext parsingContext) {
        super(configuration, parsingContext, 3);
    }
}
