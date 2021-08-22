package pl.sda;

public class CustomerTest {

    public static void main(String[] args) {
        var firstName = new Name("Jan");
        var lastName = new Name("Kowalski");
        var email = new Email("k.j@wp.pl");
        var customer = new Customer(firstName, lastName, email);

        var address = new Address("str", "Wawa", new ZipCode("02-300"), "PL");

        customer.addAddress(address);
        assert customer.getAddresses().contains(address) : "there is no address";

        var removed = customer.removeAddress(address);
        assert removed && !customer.getAddresses().contains(address) : "address is not removed";

        var customerAddresses = customer.getAddresses();
        var address2 = new Address("zxc", "Wawa", new ZipCode("99-222"), "PL");
        customerAddresses.add(address2);

        assert !customer.getAddresses().contains(address2) : "address list mutated";

        var customer2 = new Customer(firstName, lastName, email);
        assert customer2.equals(customer) : "invalid equals";
    }
}
