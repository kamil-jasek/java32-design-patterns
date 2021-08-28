package pl.sda;

import pl.sda.mail.MailService;

public class CustomerRegistration {

    private final CustomerDatabase database;
    private final MailService mailService;

    public CustomerRegistration(CustomerDatabase database, MailService mailService) {
        this.database = database;
        this.mailService = mailService;
    }

    public void registerCustomer(Customer customer) {
        if (database.customerExists(customer)) {
            throw new IllegalArgumentException("customer already exists");
        }
        database.save(customer);
        mailService.sendMail();
    }
}
