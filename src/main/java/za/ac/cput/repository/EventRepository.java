package za.ac.cput.repository;

/**
 *Name: Uyathandwa
 *Surname: Ngomana
 *Student number: 231173229
 *Group: 3H
 *Description:EventRepositoryImpl
 * Date: 25 March 2026
 **/

import za.ac.cput.domain.Event;
import za.ac.cput.domain.Organizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class EventRepository implements IEventRepository {

        private static EventRepository repository = null;
        private Map<Integer, Event> eventMap;

        private EventRepository() {
            eventMap = new HashMap<>();
        }

        public static EventRepository getRepository() {
            if (repository == null) {
                repository = new EventRepository();
            }
            return repository;
        }

        @Override
        public Event create(Event event) {
            eventMap.put(event.getEventId(), event);
            return event;
        }

        @Override
        public Event read(Integer id) {
            return eventMap.get(id);
        }

        @Override
        public Event update(Event event) {
            if (eventMap.containsKey(event.getEventId())) {
                eventMap.put(event.getEventId(), event);
                return event;
            }
            return null;
        }

        @Override
        public boolean delete(Integer id) {

            return eventMap.remove(id) != null;
        }

        @Override
        public List<Event> getAll() {

            return new ArrayList<>(eventMap.values());
        }

        @Override
        public Event findByName(String name) {
            for (Event event : eventMap.values()) {
                if (event.getName().equals(name)) {
                    return event;
                }
            }
            return null;
        }

        @Override
        public List<Event> findByDateTime(String dateTime) {
            List<Event> result = new ArrayList<>();

            for (Event event : eventMap.values()) {
                if (event.getDateTime().equals(dateTime)) {
                    result.add(event);
                }
            }

            return result;
        }

        @Override
        public List<Event> findByMaxAttendees(int maxAttendees) {
            List<Event> result = new ArrayList<>();

            for (Event event : eventMap.values()) {
                if (event.getMaxAttendees() == maxAttendees) {
                    result.add(event);
                }
            }

            return result;
        }

        @Override
        public List<Event> findByDescription(String description) {
            List<Event> result = new ArrayList<>();

            for (Event event : eventMap.values()) {
                if (event.getDescription().equals(description)) {
                    result.add(event);
                }
            }

            return result;
        }

        @Override
        public List<Event> findByOrganizer(Organizer organizer) {
            List<Event> result = new ArrayList<>();

            for (Event event : eventMap.values()) {
                if (event.getOrganizer() != null && event.getOrganizer().equals(organizer)) {
                    result.add(event);
                }
            }

            return result;
        }
    }


