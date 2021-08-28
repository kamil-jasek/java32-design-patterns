package pl.sda.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Person extends Customer {

    private final Name firstName;
    private final Name lastName;

    public Person(Email email, Name firstName, Name lastName) {
        super(email);
        this.firstName = requireNonNull(firstName);
        this.lastName = requireNonNull(lastName);
    }

    public Name getFirstName() {
        return firstName;
    }

    public Name getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName);
    }
}
