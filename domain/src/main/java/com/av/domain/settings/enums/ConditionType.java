package com.av.domain.settings.enums;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Vasiliev.Alexey on 22.11.16.
 */
public enum ConditionType {
    CONSTANT("Константа"),
    CUSTOM_RULE("Пользовательское правило"),
    DOCUMENT_ATTRIBUTE("Атрибут документа"),
    GROUP_CONDITION("Набор условий");


    private String description;

    private ConditionType(String description) {
        this.description = description;
    }

    public static ConditionType getByName(String name) {
        return ConditionType.valueOf(name);
    }

    @Override
    public String toString() {
        return description;
    }


    public static ObservableList<ConditionType> leftConditionTypes() {
        return FXCollections.observableArrayList(DOCUMENT_ATTRIBUTE);
    }

}
