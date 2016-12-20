package com.av.domain;

import com.av.domain.ifaces.INodeable;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alexey on 22.11.16.
 */


@Entity
@Table(name = "model")
public class Model implements Serializable  , INodeable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "code", length = 50)
    private String code;

    @NotEmpty
    @Column(name = "name", length = 150)
    private String name;


    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "model_id")
    private List<ModelAttrGroup> modelAttrGroups;


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


    public List<ModelAttrGroup> getModelAttrGroups() {
        return modelAttrGroups;
    }

    public void setModelAttrGroups(List<ModelAttrGroup> modelAttrGroups) {
        this.modelAttrGroups = modelAttrGroups;
    }

    @Override
    public String getNodelLabel() {
        return new StringBuilder().append(code).append(" ").append(name).toString();
    }


    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", modelAttrGroups=" + modelAttrGroups +
                '}';
    }
}
