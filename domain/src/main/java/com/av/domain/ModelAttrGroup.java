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

    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "modelAttrGroup", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    // @JoinColumn(name="attr_group_id")
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
}
