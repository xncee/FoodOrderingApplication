package model.database.repositories;

import model.CustomerPreferences;

import java.util.List;

public class PreferencesRepository implements IRepository<CustomerPreferences> {
    @Override
    public CustomerPreferences getById(int id) {
        return null;
    }

    @Override
    public List<CustomerPreferences> getAll() {
        return null;
    }

    @Override
    public void save(CustomerPreferences entity) {

    }

    @Override
    public void update(CustomerPreferences entity) {

    }

    @Override
    public void delete(int id) {

    }
}
