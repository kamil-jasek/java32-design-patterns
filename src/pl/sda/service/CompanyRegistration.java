package pl.sda.service;

import pl.sda.domain.*;
import pl.sda.event.EventPublisher;

public class CompanyRegistration extends CustomerRegistration {

    public CompanyRegistration(CustomerDatabase database, EventPublisher eventPublisher) {
        super(database, eventPublisher);
    }

    @Override
    Customer createCustomer(CustomerRegistrationForm form) {
        return new Company(new Email(form.getEmail()),
                new Name(form.getCompanyName()),
                new Nip(form.getCompanyNip()));
    }
}
