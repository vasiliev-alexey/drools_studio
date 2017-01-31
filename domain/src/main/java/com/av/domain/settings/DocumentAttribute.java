package com.av.domain.settings;

import javax.persistence.*;

/**
 * Created by alexey on 31.01.17.
 */
@Entity
@Table(name = "document_attribute")
@Access(AccessType.PROPERTY)
public class DocumentAttribute extends AbstractCondition{

    private ModelAttr attr;

    @OneToOne
    @JoinColumn(name = "attribute_id")

    public ModelAttr getAttr() {
        return attr;
    }

    public void setAttr(ModelAttr attr) {
        this.attr = attr;
    }
}
