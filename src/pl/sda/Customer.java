package pl.sda;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Customer {

    private final Name firstName;
    private final Name lastName;
    private final Email email;
    private final List<Address> addresses;

    public Customer(Name firstName, Name lastName, Email email) {
        this.firstName = requireNonNull(firstName);
        this.lastName = requireNonNull(lastName);
        this.email = requireNonNull(email);
        this.addresses = new ArrayList<>();
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

    public void addAddress(Address address) {
        if (address != null && !addresses.contains(address)) {
            addresses.add(address);
        }
    }

    public boolean removeAddress(Address address) {
        return addresses.remove(address);
    }
}
