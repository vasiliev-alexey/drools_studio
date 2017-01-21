package com.av.domain.accounting;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by vasiliev-alexey on 19.01.17.
 * Сущность - книга Учета
 */
@Entity
@Table(name = "ledger")
@Access(AccessType.PROPERTY)
public class Ledger {

    private LongProperty id;
    private StringProperty code;
    private StringProperty name;
    private Currency functionalCurrency;
    private AccountCalendar accountCalendar;
    private ChartOfAccount chartOfAccount;


    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return idProperty().get();
    }

    public LongProperty idProperty() {
        if(id == null) id= new SimpleLongProperty(this  , "id");
        return id;
    }

    public void setId(long id) {
        idProperty().set(id);
    }

    @Column(name = "code", length = 50 , unique = true)
    @NotNull(message = "com.av.domain.accounting.Ledger.code_empty}")
    public String getCode() {
        return codeProperty().get();
    }

    public StringProperty codeProperty() {
        if(code == null) code= new SimpleStringProperty(this  , "code");
        return code;
    }

    public void setCode(String code) {
        codeProperty().set(code);
    }
    @Column(name = "name", length = 150 , unique = true)
    @NotNull(message = "com.av.domain.accounting.Ledger.name_empty}")
    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        if(name == null) name= new SimpleStringProperty(this  , "name");
        return  name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }
    @Transient
    public Currency getFunctionalCurrency() {
        return functionalCurrency;
    }

    public void setFunctionalCurrency(Currency functionalCurrency) {
        this.functionalCurrency = functionalCurrency;
    }

     @Transient
         public AccountCalendar getAccountCalendar() {
        return accountCalendar;
    }

    public void setAccountCalendar(AccountCalendar accountCalendar) {
        this.accountCalendar = accountCalendar;
    }
    @Transient
    public ChartOfAccount getChartOfAccount() {
        return chartOfAccount;
    }

    public void setChartOfAccount(ChartOfAccount chartOfAccount) {
        this.chartOfAccount = chartOfAccount;
    }




}
