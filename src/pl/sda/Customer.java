package pl.sda;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Customer {

    private Name firstName;
    private Name lastName;
    private Email email;
    private List<Address> addresses;

    public Customer(Name firstName, Name lastName, Email email) {
        this.firstName = requireNonNull(firstName);
        this.lastName = requireNonNull(lastName);
        this.email = requireNonNull(email);
    }

    public Name getFirstName() {
        return firstName;
    }

    public Name getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
