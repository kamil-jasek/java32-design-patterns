package pl.sda.event;

public class SendMailCustomerRegisteredEventListener implements EventListener {

    @Override
    public void handle(Event event) {
        final var registeredEvent = (CustomerRegisteredEvent) event;
        // todo mail send
        System.out.println("sending mail: " + registeredEvent.getEmail());
    }

    @Override
    public boolean supports(Event event) {
        return event instanceof CustomerRegisteredEvent;
    }
}
