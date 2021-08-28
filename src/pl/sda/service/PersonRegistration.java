package pl.sda.service;

import pl.sda.domain.Customer;
import pl.sda.domain.Email;
import pl.sda.domain.Name;
import pl.sda.domain.Person;

public class PersonRegistration extends CustomerRegistration {

    public PersonRegistration(CustomerDatabase database, MailService mailService) {
        super(database, mailService);
    }

    @Override
    Customer createCustomer(CustomerRegistrationForm form) {
        return new Person(new Email(form.getEmail()),
                new Name(form.getFirstName()),
                new Name(form.getLastName()));
    }
}
