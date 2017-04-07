package com.av.domain.settings.enums;

/**
 * Created by alexey on 07.04.17.
 */
public enum LogicOperatorType {
    EMPTY("") ,  AND("И"), OR("ИЛИ");

    private String description;

    private LogicOperatorType(String description) {
        this.description = description;
    }

    public static LogicOperatorType getByName(String name) {
        return LogicOperatorType.valueOf(name);
    }

    @Override
    public String toString() {
        return description;
    }
}
