package com.av.domain;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alexey on 22.11.16.
 */
@Entity
@Table(name = "model_attr_group")
@Access(AccessType.PROPERTY)
public class ModelAttrGroup implements Serializable {


    private StringProperty code;
    private LongProperty id;
    private StringProperty name;

    private GroupType groupType;

    private Model model;

    private List<ModelAttr> modelAttrList;

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

    @Column(name = "name")
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

    @Column(name = "code")
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

    @ManyToOne
    @JoinColumn(name = "model_id")
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @OneToMany(mappedBy = "modelAttrGroup", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    public List<ModelAttr> getModelAttrList() {
        return modelAttrList;
    }

    public void setModelAttrList(List<ModelAttr> modelAttrList) {
        this.modelAttrList = modelAttrList;
    }

    @Column(name = "group_type")
    @Enumerated(EnumType.STRING)
    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelAttrGroup)) return false;

        ModelAttrGroup that = (ModelAttrGroup) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getCode().equals(that.getCode())) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getGroupType() != that.getGroupType()) return false;
        if (getModel() != null ? !getModel().equals(that.getModel()) : that.getModel() != null) return false;
        return getModelAttrList() != null ? getModelAttrList().equals(that.getModelAttrList()) : that.getModelAttrList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getCode().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getGroupType().hashCode();
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getModelAttrList() != null ? getModelAttrList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ModelAttrGroup{" +
                //    "code=" + code +
                //    ", id=" + id +
                //     ", name=" + name +
                //     ", groupType=" + groupType +
                '}';
    }

  /*
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {


        out.writeLong(getId());
        out.writeObject(getCode());
        out.writeObject(getName());
        out.writeObject(getGroupType());
        out.writeObject(getModel());
        out.writeObject(getModelAttrList());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readLong());
        setCode((String) in.readObject());
        setName((String)in.readObject());
        setGroupType((GroupType) in.readObject());
        setModel((Model) in.readObject());
        setModelAttrList((List<ModelAttr>)in.readObject());
    }
    */
}
