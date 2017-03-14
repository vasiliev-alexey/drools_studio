package com.av.domain.settings;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

import javax.persistence.*;

/**
 * Created by alexey on 14.03.17.
 */
@Entity
@Table(name = "condition_line")
@Access(AccessType.PROPERTY)
public class ConditionLine {

    private  LongProperty id;
    private Condition condition;
    private IntegerProperty userSeq;

    @Id
    @Column(name = "condition_line_id")
    @GeneratedValue
    public Long getId() {
        return idProperty().get();
    }

    public void setId(Long id) {
        idProperty().setValue(id);
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "condition_id")
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }


    @Column(name = "user_sequence")
    public int getUserSeq() {
        return userSeqProperty().get();
    }

    public IntegerProperty userSeqProperty() {
        if(userSeq == null) userSeq = new SimpleIntegerProperty(this, "userSeq");
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
         userSeqProperty().set(userSeq);
    }
}
