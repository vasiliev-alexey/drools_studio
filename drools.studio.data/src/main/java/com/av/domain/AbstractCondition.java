package com.av.domain;

/**
 * Created by alexey on 22.11.16.
 */
public class AbstractCondition {

    private long id;
    private String code;
    private String name;
    private ConditionType conditionType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
