package pl.sda;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static pl.sda.ArgumentValidator.validate;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private List<Address> addresses;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = requireNonNull(firstName);
        this.lastName = requireNonNull(lastName);
        this.email = requireNonNull(email);
        validate(this.firstName.matches("\\p{L}{2,}"), "first name is invalid");
        validate(this.lastName.matches("\\p{L}{2,}"), "last name is invalid");
        validate(this.email.matches("[a-zA-Z0-9\\.\\-_]{1,}@[a-zA-Z0-9\\.\\-_]{1,}\\.[a-z]{1,}"), "email is invalid");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
