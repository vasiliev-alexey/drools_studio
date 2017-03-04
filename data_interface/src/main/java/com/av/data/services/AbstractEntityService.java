package com.av.data.services;

import javafx.collections.ObservableList;

/**
 * Created by vasiliev-alexey on 04.03.17.
 */
public interface AbstractEntityService<T> {

    T save(T entity);
    ObservableList<T> getAll();
    void remove(T entity);
}
