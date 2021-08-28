package pl.sda.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Company extends Customer {

    private final Name name;
    private final Nip nip;

    public Company(Email email, Name name, Nip nip) {
        super(email);
        this.name = requireNonNull(name);
        this.nip = requireNonNull(nip);
    }

    public Name getName() {
        return name;
    }

    public Nip getNip() {
        return nip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return name.equals(company.name) && nip.equals(company.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, nip);
    }
}
