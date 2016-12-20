package com.av.ui.managers;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public interface StandardAction<T> {
    public abstract T addItem(T t);
    public abstract void EditItem(T item);
}
