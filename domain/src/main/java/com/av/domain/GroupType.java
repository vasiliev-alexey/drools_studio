package com.av.domain;

/**
 * Created by Vasiliev.Alexey on 29.11.16.
 */
public enum GroupType {
    HEADER ("Заголовок") , LINE1("Строка 1"), LINE2("Строка 2"), LINE3("Строка 3");

    private String description;

    private GroupType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
