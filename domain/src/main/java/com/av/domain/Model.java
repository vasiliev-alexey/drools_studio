package com.av.domain;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alexey on 22.11.16.
 */


@Entity
@Table(name = "model")
@Access(AccessType.PROPERTY)

public class Model implements Serializable {

    private LongProperty id;
    private StringProperty code;
    private List<ModelAttrGroup> modelAttrGroups;
    private StringProperty modelName;
    private StringProperty packageName;


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

    @NotNull(message = "Код модели должен быть заполнен")
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

    @NotNull(message = "Имя модели должно быть заполнено" )
    @Column(name = "name", length = 150)
    public String getModelName() {
        return modelNameProperty().get();
    }

    public void setModelName(String modelName) {
        modelNameProperty().set(modelName);
    }

    public StringProperty modelNameProperty() {
        if (modelName == null) modelName = new SimpleStringProperty(this, "modelName");
        return modelName;
    }

    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}
            , mappedBy = "model")
    public List<ModelAttrGroup> getModelAttrGroups() {
        return modelAttrGroups;
    }

    public void setModelAttrGroups(List<ModelAttrGroup> modelAttrGroups) {
        this.modelAttrGroups = modelAttrGroups;
    }

    @Column(name = "package")
    @NotNull
    public String getPackageName() {
        return packageNameProperty().get();
    }

    public void setPackageName(String packageName) {
        packageNameProperty().set(packageName);
    }

    public StringProperty packageNameProperty() {
        if (packageName == null) packageName = new SimpleStringProperty(this, "packageName");

        return packageName;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id.getValue() +
                ", code='" + code.getValue() + '\'' +
                ", name='" + modelName.getValue() + '\'' +
                ", modelAttrGroups=" + modelAttrGroups +
                '}';
    }

}
