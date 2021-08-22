package pl.sda;

import static pl.sda.ArgumentValidator.validate;

public class Name extends Value {

    public Name(String value) {
        super(value);
    }

    @Override
    protected void verify() {
        validate(this.value.matches("\\p{L}{2,}"), "invalid name");
    }
}
