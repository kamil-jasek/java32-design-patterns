package pl.sda;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ApplicationProperties {

    private static final ApplicationProperties APPLICATION_PROPERTIES;

    static {
        try {
            final var properties = new Properties();
            properties.load(ApplicationProperties.class.getClassLoader()
                    .getResourceAsStream("application.properties"));
            APPLICATION_PROPERTIES = new ApplicationProperties(properties);
        } catch (IOException ex) {
            throw new RuntimeException("cannot load application properties");
        }
    }

    private final Properties properties;

    /**
     * It's singleton.
     */
    private ApplicationProperties(Properties properties) {
        this.properties = Objects.requireNonNull(properties);
    }

    public Object getValue(String key) {
        return properties.get(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static ApplicationProperties getApplicationProperties() {
        return APPLICATION_PROPERTIES;
    }
}
