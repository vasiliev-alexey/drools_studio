package com.av.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by alexey on 22.11.16.
 */


@Entity
@Table(name = "MODEL")
public class Model {

    @Id
    @GeneratedValue
    private  long id;

    @NotEmpty
    @Column(name = "code" , length = 50)
    private String Code;

    @NotEmpty
    @Column(name = "name" , length = 150)
    private String Name;



}
