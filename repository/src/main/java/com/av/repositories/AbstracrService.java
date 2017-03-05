package com.av.repositories;

import com.av.data.services.AbstractEntityService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;

/**
 * Created by vasiliev-alexey on 05.03.17.
 */
public class AbstracrService<T> implements AbstractEntityService<T> {

    @PersistenceContext
    private EntityManager emf;
    private Class<T> typeOfT;
    public AbstracrService() {
        this.typeOfT = (Class<T>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public T save(T entity) {

        entity= emf.merge(entity);

        return entity;
    }
    @Transactional(readOnly = true)
    public ObservableList<T> getAll() {
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(typeOfT);
        Root<T> rootEntry = cq.from(typeOfT);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = emf.createQuery(all);
        return FXCollections.observableArrayList(allQuery.getResultList());

    }

    @Override
    public void remove(T entity) {
        emf.remove(entity);

    }
}
