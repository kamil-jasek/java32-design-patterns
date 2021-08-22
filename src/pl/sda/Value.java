package pl.sda;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public abstract class Value {

    protected String value;

    public Value(String value) {
        this.value = requireNonNull(value);
        verify();
    }

    public String getValue() {
        return value;
    }

    protected abstract void verify();
}
