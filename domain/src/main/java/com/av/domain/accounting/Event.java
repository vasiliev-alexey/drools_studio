package com.av.domain.accounting;

import com.av.domain.settings.Model;
import javafx.beans.property.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Entity
@Table(name = "event")
public class Event implements Serializable {


    private LongProperty id;
    private StringProperty code;
    private StringProperty name;
    private BooleanProperty enabled;

    private ObjectProperty<Model> model;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return idProperty().get();
    }

    public void setId(Long id) {
        idProperty().set(id);
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }

    @NotEmpty
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

    @NotEmpty
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (!code.equals(event.code)) return false;
        return name != null ? name.equals(event.name) : event.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + code.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "model_id"  )
    public Model getModel() {
        return modelProperty().get();
    }

    public ObjectProperty<Model> modelProperty() {
        if (model == null ) model = new SimpleObjectProperty<>(this , "model");
        return model;
    }

    public void setModel(Model model) {
        modelProperty().set(model);
    }

    @Type(type = "yes_no")
    @NotNull
    @Column(name = "enabled_flag")
    public boolean isEnabled() {
        return enabledProperty().get();
    }

    public BooleanProperty enabledProperty() {
        if(enabled == null) enabled = new SimpleBooleanProperty(this , "enabled");
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        enabledProperty().set(enabled);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id.get() +
                ", code='" + code.get() + '\'' +
                ", name='" + name.get() + '\'' +
                '}';
    }


}
