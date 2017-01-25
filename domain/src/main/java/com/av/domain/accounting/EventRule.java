package com.av.domain.accounting;

import javafx.beans.property.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
@Entity
@Table(name = "event_rule")
@Access(AccessType.PROPERTY)
public class EventRule {

    private LongProperty id;
    private StringProperty code;
    private StringProperty name;
    private BooleanProperty enabledFlag;
    private ObjectProperty<Event> event;

    @Id
    @GeneratedValue
    @Column(name = "id")
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

    @NotEmpty
    @Column(name = "code", length = 50)
    public String getCode() {
        return codeProperty().get();
    }

    public StringProperty codeProperty() {
        if (code == null) code = new SimpleStringProperty(this, "code");
        return code;
    }

    public void setCode(String code) {
        codeProperty().set(code);
    }

    @NotEmpty
    @Column(name = "name", length = 150)
    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        if (name == null) name = new SimpleStringProperty(this, "name");
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

   @ManyToOne
    public Event getEvent() {
        return eventProperty().get();
    }

    public ObjectProperty<Event> eventProperty() {
        if (event == null) event = new SimpleObjectProperty<>(this, "event");
        return event;
    }

    public void setEvent(Event event) {
        eventProperty().set(event);
    }

    @Type(type = "yes_no")
    @NotNull
    @Column(name = "enabled_flag")
    public boolean getEnabledFlag() {
        return enabledFlagProperty().get();
    }

    public BooleanProperty enabledFlagProperty() {
        if (enabledFlag == null) enabledFlag = new SimpleBooleanProperty(this, "enabledFlag");
        return enabledFlag;
    }

    public void setEnabledFlag(boolean enabledFlag) {
        enabledFlagProperty().set(enabledFlag);
    }
}
