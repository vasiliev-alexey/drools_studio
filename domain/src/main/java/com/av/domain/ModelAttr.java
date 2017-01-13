package com.av.domain;

import javafx.beans.property.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Vasiliev.Alexey on 22.11.16.
 */
@Entity
@Table(name = "model_attr")
@Access(AccessType.PROPERTY)
public class ModelAttr implements Serializable {


    private LongProperty id;
    private StringProperty code;
    private StringProperty name;
    private ObjectProperty<StandardValueType> attrValueType;
    private ModelAttrGroup modelAttrGroup;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return idProperty().get();
    }

    public void setId(Long id) {
        idProperty().set(id);
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }

    @Column(name = "code")
    @NotNull(message = "{com.av.domain.ModelAttr.code_empty}")
    @Size(min = 1 , message =   "{com.av.domain.ModelAttr.code_empty}")
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

    @Column(name = "name")
    @NotNull(message = "{com.av.domain.ModelAttr.name_empty}")
    @Size(min = 1 , message =  "{com.av.domain.ModelAttr.name_empty}")
    public String getName() {
        return nameProperty().get();
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    public StringProperty nameProperty() {
        if (name == null) name = new SimpleStringProperty(this, "name");
        return name;
    }

    @Column(name = "value_type")
    @NotNull(message = "{com.av.domain.ModelAttr.attrValueType_empty}")
    public StandardValueType getAttrValueType() {
        return attrValueTypeProperty().get();
    }

    public void setAttrValueType(StandardValueType attrValueType) {
        attrValueTypeProperty().set(attrValueType);
    }

    public ObjectProperty<StandardValueType> attrValueTypeProperty() {
        if (attrValueType == null) attrValueType = new SimpleObjectProperty<StandardValueType>();
        return attrValueType;
    }

    @ManyToOne
    @JoinColumn(name = "attr_group_id")
    public ModelAttrGroup getModelAttrGroup() {
        return modelAttrGroup;
    }
    public void setModelAttrGroup(ModelAttrGroup modelAttrGroup) {
        this.modelAttrGroup = modelAttrGroup;
    }
}
