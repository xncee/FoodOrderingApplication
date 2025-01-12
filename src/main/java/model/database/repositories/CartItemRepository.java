package model.database.repositories;

import model.CartItem;

import java.util.List;

public class CartItemRepository implements IRepository<CartItem> {
    @Override
    public CartItem getById(int id) {
        return null;
    }

    @Override
    public List<CartItem> getAll() {
        return null;
    }

    @Override
    public void save(CartItem entity) {

    }

    @Override
    public void update(CartItem entity) {

    }

    @Override
    public void delete(int id) {

    }
}
