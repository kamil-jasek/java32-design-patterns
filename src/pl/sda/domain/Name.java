package pl.sda.domain;

import static pl.sda.util.ArgumentValidator.validate;

public final class Name extends Value {

    public Name(String value) {
        super(value);
    }

    @Override
    protected void verify() {
        validate(this.value.matches("\\p{L}{2,}"), "invalid name");
    }
}
