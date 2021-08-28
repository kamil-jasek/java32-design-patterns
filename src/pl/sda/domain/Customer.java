package pl.sda.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public abstract class Customer {

    private final Email email;
    private final List<Address> addresses;
    private PremiumStatus premiumStatus;

    public Customer(Email email) {
        this.email = requireNonNull(email);
        this.addresses = new ArrayList<>();
    }

    public Email getEmail() {
        return email;
    }

    public List<Address> getAddresses() {
        return new ArrayList<>(addresses);
    }

    public void addAddress(Address address) {
        if (address != null && !addresses.contains(address)) {
            addresses.add(address);
        }
    }

    public boolean removeAddress(Address address) {
        return addresses.remove(address);
    }

    public void markPremium(PremiumStatus status) {
        this.premiumStatus = requireNonNull(status);
    }

    public PremiumStatus getPremiumStatus() {
        return premiumStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
