package com.av.ui.managers;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public interface StandardAction<T> {
    T addItem();

    T editItem(T t);

    void removeItem(T t);

}
