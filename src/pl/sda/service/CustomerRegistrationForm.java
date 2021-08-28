package pl.sda.service;

import static java.util.Objects.requireNonNull;

public final class CustomerRegistrationForm {

    private final String email;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final String companyNip;

    private CustomerRegistrationForm(String email,
                                    String firstName,
                                    String lastName,
                                    String companyName,
                                    String companyNip) {
        this.email = requireNonNull(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.companyNip = companyNip;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyNip() {
        return companyNip;
    }

    public static class Builder {

        private String email;
        private String firstName;
        private String lastName;
        private String companyName;
        private String companyNip;

        private Builder() {}

        // var builder = CustomerRegistrationForm.builder();
        // var form = builder.email("sss").firstName("sasas").lastName("asasa").build();
        public CustomerRegistrationForm build() {
            return new CustomerRegistrationForm(email,
                    firstName,
                    lastName,
                    companyName,
                    companyNip);
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder companyNip(String companyNip) {
            this.companyNip = companyNip;
            return this;
        }
    }
}
