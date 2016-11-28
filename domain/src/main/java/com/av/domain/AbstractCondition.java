package com.av.domain;

import javax.persistence.*;

/**
 * Created by Vasiliev.Alexey on 22.11.16.
 */
@Entity
@Table(name = "abstract_condition")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "condition_type")
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
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCondition that = (AbstractCondition) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return conditionType == that.conditionType;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + conditionType.hashCode();
        return result;
    }
}
