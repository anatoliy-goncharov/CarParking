package com.epam.cp.dao.Impl;

import com.epam.cp.dao.CarParkingDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

/**
 * Created by home on 09.01.2016.
 */
public class GenericDao<T> implements CarParkingDao{

    private static final String UNIT_NAME = "carparking";
    private Class<T> entityClass;

    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager entityManager;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public void save(Object entity) {
        entityManager.persist(entity);
    }

    public void delete(Object entityToBeRemoved) {
        entityManager.remove(entityToBeRemoved);
    }

    public T update(Object entity) {
        return (T) entityManager.merge(entity);
    }

    public Object find(int entityID) {
        return entityManager.find(entityClass, entityID);
    }

    public List findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return entityManager.createQuery(cq).getResultList();
    }

    public T findOneResult(String namedQuery, Map parameters) {
        T result = null;

        try {
            Query query = entityManager.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }

        return result;

    }


    private void populateQueryParameters(Query query, Map<String, Object> parameters) {

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

}