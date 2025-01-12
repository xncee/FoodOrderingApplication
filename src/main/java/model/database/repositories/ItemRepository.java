package model.database.repositories;

import model.Item;

import java.util.List;

public class ItemRepository implements IRepository<Item> {
    @Override
    public Item getById(int id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }

    @Override
    public void save(Item entity) {

    }

    @Override
    public void update(Item entity) {

    }

    @Override
    public void delete(int id) {

    }
}
