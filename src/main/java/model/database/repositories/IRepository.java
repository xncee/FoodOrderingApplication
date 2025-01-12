package model.database.repositories;

import java.util.List;

public interface IRepository<T> {
    T getById(int id);
    List<T> getAll(); // delete?
    void save(T entity);
    void update(T entity);
    void delete(int id);
}