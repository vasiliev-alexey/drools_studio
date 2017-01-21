package com.av.domain.accounting;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by vasiliev-alexey on 20.01.17.
 * Сущность - Валюта
 */
@Entity
@Table(name = "currency")
@Access(AccessType.PROPERTY)
public class Currency {

    private LongProperty id;
    private StringProperty code;
    private StringProperty name;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return idProperty().get();
    }

    public LongProperty idProperty() {
        if(id==null) id = new SimpleLongProperty(this , "id") ;
        return id;
    }

    public void setId(long id) {
        idProperty().set(id);
    }
    @Column(name = "code", length = 50 , unique = true)
    @Size(min = 1 , message = "com.av.domain.accounting.Currency.code_empty}")
    @NotNull(message = "com.av.domain.accounting.Currency.code_empty}")
    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        if(code==null) code = new SimpleStringProperty(this , "code") ;
        return code;
    }

    public void setCode(String code) {
        codeProperty().set(code);
    }
    @Column(name = "name", length = 150 , unique = true)
    @Size(min = 1 , message = "com.av.domain.accounting.Currency.code_empty}")
    @NotNull(message = "com.av.domain.accounting.Currency.code_empty}")
    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        if(name==null) name = new SimpleStringProperty(this , "name") ;
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }
}
