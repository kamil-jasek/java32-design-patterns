package pl.sda.service;

public class CustomerRegistrationForm {

    private String email;
    private String firstName;
    private String lastName;
    private String companyName;
    private String companyNip;

    private CustomerRegistrationForm() {}

    public static CustomerRegistrationForm createForPerson(String email, String firstName, String lastName) {
        final var form = new CustomerRegistrationForm();
        form.email = email;
        form.firstName = firstName;
        form.lastName = lastName;
        return form;
    }

    public static CustomerRegistrationForm createForCompany(String email, String name, String nip) {
        final var form = new CustomerRegistrationForm();
        form.email = email;
        form.companyName = name;
        form.companyNip = nip;
        return form;
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
}
