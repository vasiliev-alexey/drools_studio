package com.av.domain;

import javax.persistence.*;

/**
 * Created by Vasiliev.Alexey on 22.11.16.
 */
@Entity
@Table(name = "abstract_condition")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "condition_type")
public abstract class AbstractCondition {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "condition_type")
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }


    @Override
    public String toString() {
        return "AbstractCondition{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", conditionType=" + conditionType +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCondition)) return false;

        AbstractCondition that = (AbstractCondition) o;

        if (!getId().equals(that.getId())) return false;
        if (!getCode().equals(that.getCode())) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getConditionType() == that.getConditionType();
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getConditionType().hashCode();
        return result;
    }
}
