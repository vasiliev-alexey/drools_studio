package com.av.domain.settings;

/**
 * Created by alexey on 22.11.16.
 */
public enum StandardValueType {

    Date("Дата"), String("Текст"), Double("Число плавающей точности");
    private String description;

    StandardValueType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
