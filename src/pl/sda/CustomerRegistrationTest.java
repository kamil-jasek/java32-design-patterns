package pl.sda;

import pl.sda.domain.Email;
import pl.sda.domain.Name;
import pl.sda.domain.Person;
import pl.sda.service.CustomerDatabase;
import pl.sda.service.CustomerRegistrationForm;
import pl.sda.service.MailService;
import pl.sda.service.PersonRegistration;

public class CustomerRegistrationTest {

    public static void main(String[] args) {
        final var database = new CustomerDatabase();
        final var registration = new PersonRegistration(database,
                new MailService());
        final var form = CustomerRegistrationForm.createForPerson(
                "jan@wp.pl", "Jan", "Kowalski");
        registration.registerCustomer(form);

        final var savedCustomer = database.getByEmail(new Email("jan@wp.pl"));
        assert savedCustomer != null;
        assert savedCustomer.equals(new Person(new Email("jan@wp.pl"),
                new Name("Jan"),
                new Name("Kowalski")));
//        assert savedCustomer instanceof Person;
//        final var savedPerson = (Person) savedCustomer;
//        assert savedPerson.getFirstName().getValue().equals("JanX");
//        assert savedPerson.getLastName().getValue().equals("Kowalski");
    }
}
