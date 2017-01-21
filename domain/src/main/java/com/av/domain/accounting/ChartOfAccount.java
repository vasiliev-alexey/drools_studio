package com.av.domain.accounting;

import javafx.beans.property.*;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by vasiliev-alexey on 19.01.17.
 * Сущность - настройка палана счетов
 */
@Entity
@Table(name = "chart_of_account")
public class ChartOfAccount {

    private LongProperty id;
    private StringProperty segment1;
    private StringProperty segment2;
    private StringProperty segment3;
    private StringProperty segment4;
    private StringProperty segment5;
    private StringProperty segment6;
    private StringProperty segment7;
    private StringProperty segment8;
    private StringProperty segment9;
    private StringProperty segment10;

    private BooleanProperty enableFlag;
    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;

    private static final String DASH = "-";

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return idProperty().get();
    }

    public LongProperty idProperty() {
        if (id == null) id = new SimpleLongProperty(this, "id");
        return id;
    }

    public void setId(long id) {
        idProperty().set(id);
    }

    @Column(name = "segment1", length = 50)
    public String getSegment1() {
        return segment1Property().get();
    }

    public StringProperty segment1Property() {
        if (segment1 == null || segment1.isEmpty().get()) {
            segment1 = new SimpleStringProperty(this, "segment1");
            segment1.setValue(DASH);
        }
        return segment1;
    }

    public void setSegment1(String segment1) {
        segment1Property().set(segment1);
    }

    @Column(name = "segment2", length = 50)
    public String getSegment2() {
        return segment2Property().get();
    }

    public StringProperty segment2Property() {
        if (segment2 == null || segment2.isEmpty().get()) {
            segment2 = new SimpleStringProperty(this, "segment2");
            segment2.setValue(DASH);
        }
        return segment2;
    }

    public void setSegment2(String segment2) {
        segment2Property().set(segment2);
    }

    @Column(name = "segment3", length = 50)
    public String getSegment3() {
        return segment3Property().get();
    }

    public StringProperty segment3Property() {
        if (segment3 == null || segment3.isEmpty().get()) {
            segment3 = new SimpleStringProperty(this, "segment3");
            segment3.setValue(DASH);
        }
        return segment3;
    }

    public void setSegment3(String segment3) {
        segment3Property().set(segment3);
    }

    @Column(name = "segment4", length = 50)
    public String getSegment4() {
        return segment4Property().get();
    }

    public StringProperty segment4Property() {
        if (segment4 == null || segment4.isEmpty().get()) {
            segment4 = new SimpleStringProperty(this, "segment4");
            segment4.setValue(DASH);
        }
        return segment4;
    }

    public void setSegment4(String segment4) {
        segment4Property().set(segment4);
    }

    @Column(name = "segment5", length = 50)
    public String getSegment5() {
        return segment5Property().get();
    }

    public StringProperty segment5Property() {
        if (segment5 == null || segment5.isEmpty().get()) {
            segment5 = new SimpleStringProperty(this, "segment5");
            segment5.setValue(DASH);
        }
        return segment5;
    }

    public void setSegment5(String segment5) {
        segment5Property().set(segment5);
    }

    @Column(name = "segment6", length = 50)
    public String getSegment6() {
        return segment6Property().get();
    }

    public StringProperty segment6Property() {
        if (segment6 == null || segment6.isEmpty().get()) {
            segment6 = new SimpleStringProperty(this, "segment6");
            segment6.setValue(DASH);
        }
        return segment6;
    }

    public void setSegment6(String segment6) {
        segment6Property().set(segment6);
    }

    @Column(name = "segment7", length = 50)
    public String getSegment7() {
        return segment7Property().get();
    }

    public StringProperty segment7Property() {
        if (segment7 == null || segment7.isEmpty().get()) {
            segment7 = new SimpleStringProperty(this, "segment7");
            segment7.setValue(DASH);
        }
        return segment7;
    }

    public void setSegment7(String segment7) {
        segment7Property().set(segment7);
    }

    @Column(name = "segment8", length = 50)
    public String getSegment8() {
        return segment8Property().get();
    }

    public StringProperty segment8Property() {
        if (segment8 == null || segment8.isEmpty().get()) {
            segment8 = new SimpleStringProperty(this, "segment8");
            segment8.setValue(DASH);
        }
        return segment8;
    }

    public void setSegment8(String segment8) {
        segment8Property().set(segment8);
    }

    @Column(name = "segment9", length = 50)
    public String getSegment9() {
        return segment9Property().get();
    }

    public StringProperty segment9Property() {
        if (segment9 == null || segment9.isEmpty().get()) {
            segment9 = new SimpleStringProperty(this, "segment9");
            segment9.setValue(DASH);
        }
        return segment9;
    }

    public void setSegment9(String segment9) {
        segment9Property().set(segment9);
    }

    @Column(name = "segment10", length = 50)
    public String getSegment10() {
        return segment10Property().get();
    }

    public StringProperty segment10Property() {
        if (segment10 == null || segment10.isEmpty().get()) {
            segment10 = new SimpleStringProperty(this, "segment10");
            segment10.setValue(DASH);
        }
        return segment10;
    }

    public void setSegment10(String segment10) {
        segment10Property().set(segment10);
    }

    @Type(type = "yes_no")
    @Column(name = "enabled_flag")
    public boolean isEnableFlag() {
        return enableFlagProperty().get();
    }

    public BooleanProperty enableFlagProperty() {
        if (enableFlag == null) {
            enableFlag = new SimpleBooleanProperty(this, "enableFlag");
            enableFlag.setValue(true);
        }
        return enableFlag;
    }

    public void setEnableFlag(boolean enableFlag) {
        enableFlagProperty().set(enableFlag);
    }

    @Column(name = "start_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateAsString")
    public LocalDate getStartDate() {
        return startDateProperty().get();
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        if (startDate == null) startDate = new SimpleObjectProperty<>(this, "startDate");
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        startDateProperty().set(startDate);
    }

    @Column(name = "end_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateAsString")
    public LocalDate getEndDate() {
        return endDateProperty().get();
    }

    public ObjectProperty<LocalDate> endDateProperty() {
        if (endDate == null) endDate = new SimpleObjectProperty<>(this, "endDate");
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        endDateProperty().set(endDate);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChartOfAccount that = (ChartOfAccount) o;

        if (!segment1.equals(that.segment1)) return false;
        if (!segment2.equals(that.segment2)) return false;
        if (!segment3.equals(that.segment3)) return false;
        if (!segment4.equals(that.segment4)) return false;
        if (!segment5.equals(that.segment5)) return false;
        if (!segment6.equals(that.segment6)) return false;
        if (!segment7.equals(that.segment7)) return false;
        if (!segment8.equals(that.segment8)) return false;
        if (!segment9.equals(that.segment9)) return false;
        return segment10.equals(that.segment10);
    }

    @Override
    public int hashCode() {
        int result = segment1.hashCode();
        result = 31 * result + segment2.hashCode();
        result = 31 * result + segment3.hashCode();
        result = 31 * result + segment4.hashCode();
        result = 31 * result + segment5.hashCode();
        result = 31 * result + segment6.hashCode();
        result = 31 * result + segment7.hashCode();
        result = 31 * result + segment8.hashCode();
        result = 31 * result + segment9.hashCode();
        result = 31 * result + segment10.hashCode();
        return result;
    }
}
