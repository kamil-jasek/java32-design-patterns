package pl.sda.service;

import pl.sda.domain.Customer;
import pl.sda.domain.Email;

public abstract class CustomerRegistration {

    private final CustomerDatabase database;
    private final MailService mailService;

    public CustomerRegistration(CustomerDatabase database, MailService mailService) {
        this.database = database;
        this.mailService = mailService;
    }

    public void registerCustomer(CustomerRegistrationForm form) {
        if (database.emailExists(new Email(form.getEmail()))) {
            throw new IllegalArgumentException("customer already exists");
        }
        final var customer = createCustomer(form);
        database.save(customer);
        mailService.sendMail();
    }

    abstract Customer createCustomer(CustomerRegistrationForm form);
}
