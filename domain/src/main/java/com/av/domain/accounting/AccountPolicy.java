package com.av.domain.accounting;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by vasiliev-alexey on 19.01.17.
 * Сущность - учетная политика
 */
public class AccountPolicy {

    private StringProperty code;
    private StringProperty name;

    private BooleanProperty enabled;

    private ChartOfAccount chartOfAccount;
    private AccountCalendar accountCalendar;
    private Ledger ledger;

}
