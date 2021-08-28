package pl.sda.service;

import pl.sda.domain.*;

public class CompanyRegistration extends CustomerRegistration {

    public CompanyRegistration(CustomerDatabase database, MailService mailService) {
        super(database, mailService);
    }

    @Override
    Customer createCustomer(CustomerRegistrationForm form) {
        return new Company(new Email(form.getEmail()),
                new Name(form.getCompanyName()),
                new Nip(form.getCompanyNip()));
    }
}
