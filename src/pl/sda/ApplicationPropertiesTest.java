package pl.sda;

import pl.sda.util.ApplicationProperties;

public class ApplicationPropertiesTest {

    public static void main(String[] args) {
        final var applicationProperties = ApplicationProperties.getApplicationProperties();
        assert applicationProperties.getInt("test") == 1;
        assert applicationProperties.getValue("databaseUser").equals("test");
    }
}
