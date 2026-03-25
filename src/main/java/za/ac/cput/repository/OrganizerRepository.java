package za.ac.cput.repository;

import za.ac.cput.domain.Organizer;

import java.util.List;
import java.util.*;

/**Student name: Amanda Msutu
 * Student number: 222428600
 * Group: 3H
 * OrganizerRepository.java
 * Date: 25 March 2026
 * **/

public class OrganizerRepository implements IOrganizerRepository{
    private static OrganizerRepository repository = null;
    private Map<Integer, Organizer> organizerMap;

    public OrganizerRepository() {
        organizerMap = new HashMap<>();
    }

    public static OrganizerRepository getRepository() {
        if (repository == null){
            repository = new OrganizerRepository();
        }
        return repository;
    }

    @Override
    public Organizer create(Organizer organizer) {
        organizerMap.put(organizer.getUserId(), organizer);
        return organizer;
    }

    @Override
    public Organizer read(Integer id) {
        return organizerMap.get(id);
    }

    @Override
    public Organizer update(Organizer organizer) {
        if (organizerMap.containsKey(organizer.getUserId())){
            organizerMap.put(organizer.getUserId(), organizer);
            return organizer;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (organizerMap.containsKey(id)){
            organizerMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Organizer> getAll() {
        return new ArrayList<>(organizerMap.values());
    }
}
