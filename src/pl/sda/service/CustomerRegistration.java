package pl.sda.service;

import pl.sda.domain.Customer;
import pl.sda.domain.Email;
import pl.sda.event.CustomerRegisteredEvent;
import pl.sda.event.EventPublisher;

public abstract class CustomerRegistration {

    private final CustomerDatabase database;
    private final EventPublisher eventPublisher;

    public CustomerRegistration(CustomerDatabase database, EventPublisher eventPublisher) {
        this.database = database;
        this.eventPublisher = eventPublisher;
    }

    public void registerCustomer(CustomerRegistrationForm form) {
        if (database.emailExists(new Email(form.getEmail()))) {
            throw new IllegalArgumentException("customer already exists");
        }
        final var customer = createCustomer(form);
        database.save(customer);
        eventPublisher.publishEvent(new CustomerRegisteredEvent(form.getEmail()));
    }

    abstract Customer createCustomer(CustomerRegistrationForm form);
}
