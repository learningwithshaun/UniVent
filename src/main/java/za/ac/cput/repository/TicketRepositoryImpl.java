package za.ac.cput.repository;


/**
 *Name: Zusiphe
 *Surname: Mvovo
 *Student number: 230816851
 *Group: 3H
 *Description:TicketRepositoryImpl
 * Date: 25 March 2026
 **/

import za.ac.cput.domain.Ticket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketRepositoryImpl implements TicketRepository {

    private static TicketRepositoryImpl instance;
    private final Map<Integer, Ticket> store = new HashMap<>();

    private TicketRepositoryImpl() {}

    public static TicketRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TicketRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Ticket create(Ticket entity) {
        store.put(entity.getTicketId(), entity);
        return entity;
    }

    @Override
    public Ticket read(Integer id) {
        return store.get(id);
    }

    @Override
    public Ticket update(Ticket entity) {
        if (store.containsKey(entity.getTicketId())) {
            store.put(entity.getTicketId(), entity);
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (store.containsKey(id)) {
            store.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Ticket> getAll() {
        return new ArrayList<>(store.values());
    }
}