package com.av.domain.accounting;

import javafx.beans.property.*;

import javax.persistence.*;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
@Entity
@Table(name = "segment_description")
@Access(AccessType.PROPERTY)
public class SegmentDescription {

    private ChartOfAccountStructure chartOfAccountStructure;
    private LongProperty id;
    private IntegerProperty position;
    private StringProperty description;

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

    @Column(name = "position")
    public int getPosition() {
        return positionProperty().get();
    }

    public void setPosition(int position) {
        positionProperty().set(position);
    }

    public IntegerProperty positionProperty() {
        if (position == null) position = new SimpleIntegerProperty(this, "position");

        return position;
    }

    @Column(name = "description")
    public String getDescription() {
        return descriptionProperty().get();
    }

    public void setDescription(String description) {
        descriptionProperty().set(description);
    }

    public StringProperty descriptionProperty() {
        if (description == null) description = new SimpleStringProperty(this, "description");
        return description;
    }

    @ManyToOne
    @JoinColumn(name = "chart_of_account_structure_id")
    public ChartOfAccountStructure getChartOfAccountStructure() {
        return chartOfAccountStructure;
    }

    public void setChartOfAccountStructure(ChartOfAccountStructure chartOfAccountStructure) {
        this.chartOfAccountStructure = chartOfAccountStructure;
    }
}
