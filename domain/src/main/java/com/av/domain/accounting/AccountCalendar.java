package com.av.domain.accounting;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by vasiliev-alexey on 19.01.17.
 * <p>
 * Сущность  - учетного календаря
 */

@Entity
@Table(name = "account_calendar")
@Access(AccessType.PROPERTY)
public class AccountCalendar {

    private LongProperty id;
    private List<AccountPeriod> periodList;
    private StringProperty code;
    private StringProperty name;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public long getId() {
        return idProperty().get();
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }

    public void setId(long id) {
        idProperty().set(id);
    }

    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true
            , mappedBy = "accountCalendar")

    public List<AccountPeriod> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<AccountPeriod> periodList) {
        this.periodList = periodList;
    }


    @NotNull(message = "{com.av.domain.accounting.AccountCalendar.code_empty}")
    @Size(min = 1, message = "{com.av.domain.accounting.AccountCalendar.code_empty}")
    @Column(name = "code", length = 50)
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

    @NotNull(message = "{com.av.domain.accounting.AccountCalendar.name_empty}")
    @Size(min = 1, message = "{com.av.domain.accounting.AccountCalendar.name_empty}")
    @Column(name = "name", length = 150)
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
}
