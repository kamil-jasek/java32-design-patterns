package pl.sda.domain;

import static pl.sda.util.ArgumentValidator.validate;

public class Nip extends Value {

    public Nip(String value) {
        super(value);
    }

    @Override
    protected void verify() {
        validate(value.matches("\\d{11}"), "invalid nip: " + value);
    }
}
