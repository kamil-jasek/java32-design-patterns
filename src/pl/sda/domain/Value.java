package pl.sda.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public abstract class Value {

    protected final String value;

    public Value(String value) {
        this.value = requireNonNull(value);
        verify();
    }

    public String getValue() {
        return value;
    }

    protected abstract void verify();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return value.equals(value1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
