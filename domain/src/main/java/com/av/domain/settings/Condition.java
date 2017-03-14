package com.av.domain.settings;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alexey on 13.03.17.
 */
@Entity
@Table(name = "condition")
public class Condition {

    private LongProperty id;
    private StringProperty code;
    private StringProperty name;
    private List<ConditionLine> conditionLines;


    @Id
    @Column(name = "id")
    @GeneratedValue
    public Long getId() {
        return idProperty().get();
    }

    public void setId(Long id) {
        idProperty().setValue(id);
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }


    @Column(name = "code", length = 50)
    public String getCode() {
        return codeProperty().get();
    }

    public void setCode(String code) {
        codeProperty().set(code);
    }

    public StringProperty codeProperty() {
        if (code == null) code = new SimpleStringProperty(this, "code");
        return code;

    }

    @Column(name = "name", length = 150)
    public String getConditionName() {
        return conditionNameProperty().get();
    }

    public void setConditionName(String modelName) {
        conditionNameProperty().set(modelName);
    }

    public StringProperty conditionNameProperty() {
        if (name == null) name = new SimpleStringProperty(this, "modelName");
        return name;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL }  , orphanRemoval = true
            , mappedBy = "condition")
    public List<ConditionLine> getConditionLines() {
        return conditionLines;
    }

    public void setConditionLines(List<ConditionLine> conditionLines) {
        this.conditionLines = conditionLines;
    }
}
