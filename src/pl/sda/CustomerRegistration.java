package pl.sda;

public class CustomerRegistration {

    private final CustomerDatabase database;

    public CustomerRegistration(CustomerDatabase database) {
        this.database = database;
    }

    public void registerCustomer(Customer customer) {
        if (database.customerExists(customer)) {
            throw new IllegalArgumentException("customer already exists");
        }
        database.save(customer);
    }
}
