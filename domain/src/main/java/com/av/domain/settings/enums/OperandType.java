package com.av.domain.settings.enums;

/**
 * Created by vasiliev-alexey on 07.04.17.
 */
public enum OperandType {

    EMPTY("") ,  EQUALS("равно"), NOT_EQUALS("не равно");

    private String description;

    private OperandType(String description) {
        this.description = description;
    }

    public static OperandType getByName(String name) {
        return OperandType.valueOf(name);
    }

    @Override
    public String toString() {
        return description;
    }





}
