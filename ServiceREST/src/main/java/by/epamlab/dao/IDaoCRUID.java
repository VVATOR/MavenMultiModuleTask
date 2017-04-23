package by.epamlab.dao;

import by.epamlab.exception.ElementNotFoundException;

public interface IDaoCRUID<T> {
    int create(T element) throws ElementNotFoundException;

    T getById(int id) throws ElementNotFoundException;

    T update(T element) throws ElementNotFoundException;

    void delete(int id);

}
