package org.flywaydb.community.database;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.extensibility.PluginMetadata;
import org.flywaydb.core.internal.util.FileUtils;

public class TiberoDatabaseExtension implements PluginMetadata {
    public String getDescription() {
        return "Community-contributed Databricks database support extension " + readVersion() + " by Redgate";
    }

    public static String readVersion() {
        try {
            return FileUtils.copyToString(
                TiberoDatabaseExtension.class.getClassLoader().getResourceAsStream("org/flywaydb/community/database/databricks/version.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FlywayException("Unable to read extension version: " + e.getMessage(), e);
        }
    }
}
