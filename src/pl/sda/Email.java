package pl.sda;

import static pl.sda.ArgumentValidator.validate;

public final class Email extends Value {

    public Email(String value) {
        super(value);
    }

    @Override
    protected void verify() {
        validate(this.value.matches("[a-zA-Z0-9\\.\\-_]{1,}@[a-zA-Z0-9\\.\\-_]{1,}\\.[a-z]{1,}"), "email is invalid");
    }
}
