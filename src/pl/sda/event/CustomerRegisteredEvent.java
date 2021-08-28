package pl.sda.event;

public class CustomerRegisteredEvent implements Event {

    private final String email;

    public CustomerRegisteredEvent(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
