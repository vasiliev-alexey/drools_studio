package com.av.domain;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * Created by Vasiliev.Alexey on 22.11.16.
 */
@Entity
@Table(name = "constant_condition")
@PrimaryKeyJoinColumn(name = "id")
public class ConstantCondition extends AbstractCondition {

    @Column(name = "double_value")
    private Double DoubleValue;
    @Column(name = "string_value")
    private String StringValue;
    @Column(name = "date_value")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateAsString")
    private LocalDate DateValue;
    @Column(name = "constant_value_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private StandardValueType valueType;


    public ConstantCondition() {
        super();
        super.setConditionType(ConditionType.CONSTANT);
    }

    public Double getDoubleValue() {
        return DoubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        DoubleValue = doubleValue;
    }

    public String getStringValue() {
        return StringValue;
    }

    public void setStringValue(String stringValue) {
        StringValue = stringValue;
    }

    public LocalDate getDateValue() {
        return DateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        DateValue = dateValue;
    }

    public StandardValueType getValueType() {
        return valueType;
    }

    public void setValueType(StandardValueType valueType) {
        this.valueType = valueType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstantCondition)) return false;

        ConstantCondition that = (ConstantCondition) o;

        if (Double.compare(that.getDoubleValue(), getDoubleValue()) != 0) return false;
        if (getStringValue() != null ? !getStringValue().equals(that.getStringValue()) : that.getStringValue() != null)
            return false;
        if (getDateValue() != null ? !getDateValue().equals(that.getDateValue()) : that.getDateValue() != null)
            return false;
        return getValueType() == that.getValueType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (DoubleValue != null ? DoubleValue.hashCode() : 0);
        result = 31 * result + (StringValue != null ? StringValue.hashCode() : 0);
        result = 31 * result + (DateValue != null ? DateValue.hashCode() : 0);
        result = 31 * result + valueType.hashCode();
        return result;
    }
}
