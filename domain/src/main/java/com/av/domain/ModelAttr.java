package com.av.domain;

import javax.jws.WebParam;
import javax.persistence.*;

/**
 * Created by alexey on 22.11.16.
 */
@Entity
@Table(name = "model_attr")
public class ModelAttr {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "attr_group_id")
    private ModelAttrGroup modelAttrGroup;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelAttr)) return false;

        ModelAttr modelAttr = (ModelAttr) o;

        if (!getId().equals(modelAttr.getId())) return false;
        if (!getCode().equals(modelAttr.getCode())) return false;
        return getName() != null ? getName().equals(modelAttr.getName()) : modelAttr.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }


    public ModelAttrGroup getModelAttrGroup() {
        return modelAttrGroup;
    }

    public void setModelAttrGroup(ModelAttrGroup modelAttrGroup) {
        this.modelAttrGroup = modelAttrGroup;
    }
}
