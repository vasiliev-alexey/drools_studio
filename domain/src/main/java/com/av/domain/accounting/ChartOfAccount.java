package com.av.domain.accounting;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;
import org.joda.time.LocalDate;

/**
 * Created by vasiliev-alexey on 19.01.17.
 * Сущность - настройка палана счетов
 */
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
    private LocalDate startDate;
    private LocalDate endDate;

}
