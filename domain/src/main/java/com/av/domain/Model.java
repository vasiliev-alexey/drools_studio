package com.av.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexey on 22.11.16.
 */


@Entity
@Table(name = "model")
public class Model implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  Long id;

    @NotEmpty
    @Column(name = "code" , length = 50)
    private String code;

    @NotEmpty
    @Column(name = "name" , length = 150)
    private String name;


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



}
