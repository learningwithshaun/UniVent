package za.ac.cput.factory;

import za.ac.cput.domain.Event;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {

    @Test
    void createEvent() {
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
    void createEventFail() {

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
