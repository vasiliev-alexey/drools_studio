package com.av.domain.settings;

import com.av.domain.settings.enums.LogicOperatorType;
import com.av.domain.settings.enums.OperandType;
import javafx.beans.property.*;

import javax.persistence.*;

/**
 * Created by alexey on 14.03.17.
 */
@Entity
@Table(name = "condition_line")
@Access(AccessType.PROPERTY)
public class ConditionLine {

    private LongProperty id;
    private Condition condition;
    private IntegerProperty userSeq;

    private StringProperty leftBracket;
    private StringProperty rightBracket;
    private ObjectProperty <LogicOperatorType> logicOperatorType;
    private ObjectProperty <OperandType> operandType;

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

    public void setUserSeq(Integer userSeq) {
        if(userSeq!=null)
        userSeqProperty().set(userSeq);
    }

    public IntegerProperty userSeqProperty() {
        if (userSeq == null) userSeq = new SimpleIntegerProperty(this, "userSeq");
        return userSeq;
    }

    @Column(name = "bracket_left_code")
    public String getLeftBracket() {
        return leftBracketProperty().get();
    }

    public StringProperty leftBracketProperty() {
        if(leftBracket == null) leftBracket = new SimpleStringProperty(this , "leftBracket");
        return leftBracket;
    }

    public void setLeftBracket(String leftBracket) {
        leftBracketProperty().set(leftBracket);
    }

    @Column(name = "bracket_right_code")
    public String getRightBracket() {
        return rightBracketProperty().get();
    }

    public StringProperty rightBracketProperty() {
        if(rightBracket == null) rightBracket = new SimpleStringProperty(this , "rightBracket");

        return rightBracket;
    }

    public void setRightBracket(String rightBracket) {
        rightBracketProperty().set(rightBracket);
    }

    @Column(name = "logic_operator")
    @Enumerated(EnumType.STRING)
    public LogicOperatorType getLogicOperatorType() {
        return logicOperatorTypeProperty().get();
    }

    public ObjectProperty<LogicOperatorType> logicOperatorTypeProperty() {
        if(logicOperatorType ==null) logicOperatorType = new SimpleObjectProperty<>(this , "logicOperatorType");
        return logicOperatorType;
    }

    public void setLogicOperatorType(LogicOperatorType logicOperatorType) {
        logicOperatorTypeProperty().set(logicOperatorType);
    }

    @Column(name = "operand")
    @Enumerated(EnumType.STRING)
    public OperandType getOperandType() {
        return  operandTypeProperty().get();
    }

    public ObjectProperty<OperandType> operandTypeProperty() {
        if(operandType ==null) operandType = new SimpleObjectProperty<>(this , "operandType");
        return operandType;
    }

    public void setOperandType(OperandType operandType) {
        operandTypeProperty().set(operandType);
    }
}
