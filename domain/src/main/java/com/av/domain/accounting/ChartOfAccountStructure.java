package com.av.domain.accounting;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */

@Entity
@Table(name = "chart_of_account_structure")
@Access(AccessType.PROPERTY)
public class ChartOfAccountStructure   {

    private LongProperty id;
    private StringProperty code;
    private StringProperty name;
    private List<SegmentDescription> segmentDescriptionList;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return idProperty().get();
    }

    public void setId(long id) {
        idProperty().set(id);
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }


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

    @OneToMany(mappedBy = "chartOfAccountStructure" , orphanRemoval = true , cascade = CascadeType.ALL)
    public List<SegmentDescription> getSegmentDescriptionList() {
        return segmentDescriptionList;
    }

    public void setSegmentDescriptionList(List<SegmentDescription> segmentDescriptionList) {
        this.segmentDescriptionList = segmentDescriptionList;
    }
}
