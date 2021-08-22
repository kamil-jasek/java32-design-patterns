package pl.sda;

import static pl.sda.ArgumentValidator.validate;

public final class ZipCode extends Value {

    public ZipCode(String value) {
        super(value);
    }

    @Override
    protected void verify() {
        validate(value.matches("\\d{2}-\\d{3}"), "invalid zip code");
    }
}
