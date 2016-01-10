package com.epam.cp.dao;

import java.util.List;
import java.util.Map;

public interface CarParkingDao<T> {

    void save(T entity);
    void delete (T entityToBeRemoved);
    T update(T entity);
    T find(Long entityID);
    List<T> findAll();
    T findOneResult(String namedQuery, Map<String, Object> parameters);
}
