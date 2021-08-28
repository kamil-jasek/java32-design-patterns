package pl.sda.event;

public interface EventListener {

    void handle(Event event);

    boolean supports(Event event);
}
