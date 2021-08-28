package pl.sda;

import pl.sda.domain.*;

import java.time.Instant;
import java.util.HashSet;

public class CustomerTest {

    public static void main(String[] args) {
        var firstName = new Name("Jan");
        var lastName = new Name("Kowalski");
        var email = new Email("k.j@wp.pl");
        var customer = new Person(email, firstName, lastName);

        var address = new Address("str", "Wawa", new ZipCode("02-300"), "PL");

        customer.addAddress(address);
        assert customer.getAddresses().contains(address) : "there is no address";

        var removed = customer.removeAddress(address);
        assert removed && !customer.getAddresses().contains(address) : "address is not removed";

        var customerAddresses = customer.getAddresses();
        var address2 = new Address("zxc", "Wawa", new ZipCode("99-222"), "PL");
        customerAddresses.add(address2);

        assert !customer.getAddresses().contains(address2) : "address list mutated";

        var customer2 = new Person(email, firstName, lastName);
        assert customer2.equals(customer) : "invalid equals";

        final var set = new HashSet<Customer>();
        set.add(customer); // customer.hashcode()
        set.add(customer2);

        customer.markPremium(new PremiumStatus(true, Instant.now()));

        assert set.contains(customer); // customer.hashcode()
    }
}
