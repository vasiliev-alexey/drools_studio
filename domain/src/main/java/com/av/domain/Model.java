package com.av.domain;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alexey on 22.11.16.
 */


@Entity
@Table(name = "model")
public class Model implements Serializable {

    private LongProperty id;

    @Id
    @Column(name = "id")
    public Long getId() {
        return idProperty().get();
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id") ;
        return id;
    }


    public void setId(Long id) {
        idProperty().set(id);
    }



    @NotEmpty
    @Column(name = "code", length = 50)
    public String getCode() {
        return codeProperty().get();
    }

    public StringProperty codeProperty() {
        if (code == null) code = new SimpleStringProperty(this, "code");
        return code;

    }

    public void setCode(String code) {
        codeProperty().set(code);
    }

    private StringProperty code;

    private List<ModelAttrGroup> modelAttrGroups;


    private StringProperty modelName;

    @NotEmpty
    @Column(name = "name", length = 150)
    public String getModelName() {
        return modelNameProperty().get();
    }

    public StringProperty modelNameProperty() {
        if (modelName == null) modelName = new SimpleStringProperty(this, "modelName");
        return modelName;
    }


    public void setModelName(String modelName) {
        modelNameProperty().set(modelName);
    }






    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "model_id")
    public List<ModelAttrGroup> getModelAttrGroups() {
        return modelAttrGroups;
    }

    public void setModelAttrGroups(List<ModelAttrGroup> modelAttrGroups) {
        this.modelAttrGroups = modelAttrGroups;
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
