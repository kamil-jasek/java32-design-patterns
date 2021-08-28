package pl.sda.service;

import pl.sda.domain.Customer;
import pl.sda.domain.Email;

import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase {

    private final Map<Email, Customer> database = new HashMap<>();

    public void save(Customer customer) {
        database.put(customer.getEmail(), customer);
    }

    public boolean emailExists(Email email) {
        return database.containsKey(email);
    }

    public Customer getByEmail(Email email) {
        return database.get(email);
    }
}
