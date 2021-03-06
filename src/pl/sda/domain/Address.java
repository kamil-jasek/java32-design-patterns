package pl.sda.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Address {

    private final String street;
    private final String city;
    private final ZipCode zipCode;
    private final String countryCode;

    public Address(String street, String city, ZipCode zipCode, String countryCode) {
        this.street = requireNonNull(street);
        this.city = requireNonNull(city);
        this.zipCode = requireNonNull(zipCode);
        this.countryCode = requireNonNull(countryCode);
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) && city.equals(address.city) && zipCode.equals(address.zipCode) && countryCode.equals(address.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, zipCode, countryCode);
    }
}
