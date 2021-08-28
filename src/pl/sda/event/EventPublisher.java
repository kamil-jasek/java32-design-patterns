package pl.sda.event;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {

    private final List<EventListener> listeners;

    public EventPublisher() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(EventListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public boolean removeListener(EventListener listener) {
        return listeners.remove(listener);
    }

    public void publishEvent(Event event) {
        for (final var listener : listeners) {
            if (listener.supports(event)) {
                listener.handle(event);
            }
        }
    }
}
