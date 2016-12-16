package com.av.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alexey on 22.11.16.
 */
@Entity
@Table(name = "model_attr_group")
public class ModelAttrGroup {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @Column (name = "group_type")
    @Enumerated(EnumType.STRING)
    private GroupType groupType;


    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "modelAttrGroup", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ModelAttr> modelAttrList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<ModelAttr> getModelAttrList() {
        return modelAttrList;
    }

    public void setModelAttrList(List<ModelAttr> modelAttrList) {
        this.modelAttrList = modelAttrList;
    }

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
}
