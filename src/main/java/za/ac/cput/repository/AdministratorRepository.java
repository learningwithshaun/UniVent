package za.ac.cput.repository;

import za.ac.cput.domain.Administrator;

import java.util.*;

/**
 * Student name: Amanda Msutu
 * Student number: 222428600
 * Group: 3H
 * AdministratorRepository.java
 * Date: 25 March 2026
 *
 **/

public class AdministratorRepository implements IAdministratorRepository {
    private static AdministratorRepository repository = null;
    private Map<Integer, Administrator> administratorMap;

    public AdministratorRepository() {
        administratorMap = new HashMap<>();
    }

    public static AdministratorRepository getRepository() {
        if (repository == null) {
            repository = new AdministratorRepository();
        }
        return repository;
    }

    @Override
    public Administrator create(Administrator administrator) {
        administratorMap.put(administrator.getUserId(), administrator);
        return administrator;
    }

    @Override
    public Administrator read(Integer id) {
        return administratorMap.get(id);
    }

    @Override
    public Administrator update(Administrator administrator) {
        if (administratorMap.containsKey(administrator.getUserId())){
            administratorMap.put(administrator.getUserId(), administrator);
            return administrator;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (administratorMap.containsKey(id)){
            administratorMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Administrator> getAll() {
        return new ArrayList<>(administratorMap.values());
    }
}

