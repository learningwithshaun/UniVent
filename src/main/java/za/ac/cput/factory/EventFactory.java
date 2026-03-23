package za.ac.cput.factory;

import za.ac.cput.domain.Event;
import za.ac.cput.util.Helper;

public class EventFactory {

    public static Event createEvent(String name,
                                    String description,
                                    String dateTime,
                                    int maxAttendees) {

        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Event name cannot be empty");
        }

        if (Helper.isNullOrEmpty(description)) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        if (!Helper.isValidDateTime(dateTime)) {
            throw new IllegalArgumentException("Invalid date and time");

        }

        if (!Helper.isPositive(maxAttendees)) {
            throw new IllegalArgumentException("Max attendees must be greater than 0");
        }

        return new Event.Builder()
                .setName(name)
                .setDescription(description)
                .setDateTime(dateTime)
                .setMaxAttendees(maxAttendees)
                .build();
    }
}