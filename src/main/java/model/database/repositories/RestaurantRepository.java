package model.database.repositories;

import model.users.Restaurant;
import model.users.User;

import java.util.List;

public class RestaurantRepository implements IRepository<Restaurant> {

    @Override
    public Restaurant getById(int id) {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public void save(Restaurant entity) {

    }

    @Override
    public void update(Restaurant entity) {

    }

    @Override
    public void delete(int id) {

    }
}
