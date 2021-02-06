package properties;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfiguration {

    private Properties prop;

    public DatabaseConfiguration() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("/db.properties")) {
            prop.load(is);

        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file!");
        }
    }

    public DatabaseConfiguration(File file) {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
        ) {
            prop.load(fileInputStream);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!", ioe);
        }
    }

    public String getHost() {
        return prop.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(prop.getProperty("db.port"));
    }

    public String getSchema() {
        return prop.getProperty("db.schema");
    }
}


