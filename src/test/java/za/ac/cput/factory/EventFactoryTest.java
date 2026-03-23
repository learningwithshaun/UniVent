package za.ac.cput.factory;

import org.junit.Test;
import za.ac.cput.domain.Event;

import static org.junit.Assert.*;

public class EventFactoryTest {

    @Test
    public void createEvent() {
        Event event = EventFactory.createEvent(
                "Tech Talk",
                "Java Workshop",
                "2026-05-10 10:00",
                100
        );

        assertNotNull(event);
        System.out.println(event);
    }

    @Test
    public void createEventFail() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EventFactory.createEvent(
                    "",
                    "Java Workshop",
                    "2026-05-10 10:00",
                    100
            );
        });

        System.out.println(exception.getMessage());
    }
}
