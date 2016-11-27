package com.av.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Vasiliev.Alexey on 22.11.16.
 */
@Entity
@Table(name = "video_releases")
@DiscriminatorValue("CONSTANT")
public class ConstantCondition extends AbstractCondition {

@Column(name = "double_value")
    private double DoubleValue;
    @Column(name = "string_value")
    private String StringValue;
    @Column(name = "date_value")
    private LocalDate DateValue;
    @Column
    @Enumerated(EnumType.STRING)
    private ConstantValueType valueType;


    public double getDoubleValue() {
        return DoubleValue;
    }

    public void setDoubleValue(double doubleValue) {
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

    public ConstantValueType getValueType() {
        return valueType;
    }

    public void setValueType(ConstantValueType valueType) {
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
        int result;
        long temp;
        temp = Double.doubleToLongBits(getDoubleValue());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getStringValue() != null ? getStringValue().hashCode() : 0);
        result = 31 * result + (getDateValue() != null ? getDateValue().hashCode() : 0);
        result = 31 * result + getValueType().hashCode();
        return result;
    }
}
