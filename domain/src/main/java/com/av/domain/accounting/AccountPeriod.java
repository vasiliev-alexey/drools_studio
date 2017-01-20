package com.av.domain.accounting;

import javafx.beans.property.*;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by vasiliev-alexey on 19.01.17.
 * сущность период
 */
@Entity
@Table(name = "account_period")
@Access(AccessType.PROPERTY)
public class AccountPeriod {

    private LongProperty id;
    private IntegerProperty periodNum;
    private StringProperty code;
    private StringProperty name;
    private LocalDate startDate;
    private LocalDate endDate;
    private AccountCalendar accountCalendar;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return idProperty().get();
    }

    public void setId(long id) {
        idProperty().set(id);
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }

    @Column(name = "period_num")
    @NotNull(message = "com.av.domain.accounting.AccountPeriod.code_empty}")
    public int getPeriodNum() {
        return periodNumProperty().get();
    }

    public void setPeriodNum(int periodNum) {
        periodNumProperty().set(periodNum);
    }

    public IntegerProperty periodNumProperty() {
        if (periodNum == null) periodNum = new SimpleIntegerProperty(this, "periodNum");
        return periodNum;
    }

    @Column(name = "code")
    @NotNull(message = "{com.av.domain.accounting.AccountPeriod.code_empty}")
    @Size(min = 1, message = "{com.av.domain.accounting.AccountPeriod.code_empty}")
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

    @NotNull(message = "{com.av.domain.accounting.AccountPeriod.name_empty}")
    @Size(min = 1, message = "{com.av.domain.accounting.AccountPeriod.name_empty}")
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

    @Column(name = "start_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateAsString")
    @NotNull(message = "{com.av.domain.accounting.AccountPeriod.startDate_empty}")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateAsString")
    @NotNull(message = "{com.av.domain.accounting.AccountPeriod.endDate_empty}")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @ManyToOne
    @JoinColumn(name = "account_calendar_id")
    public AccountCalendar getAccountCalendar() {
        return accountCalendar;
    }

    public void setAccountCalendar(AccountCalendar accountCalendar) {
        this.accountCalendar = accountCalendar;
    }
}
