package pl.sda;

public class CustomerTest {

    public static void main(String[] args) {
        var firstName = new Name("Jan");
        var lastName = new Name("Kowalski");
        var email = new Email("k.j@wp.pl");
        var customer = new Customer(firstName, lastName, email);


    }
}
