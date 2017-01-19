package com.av.domain.accounting;

/**
 * Created by vasiliev-alexey on 19.01.17.
 */
public enum PeriodStatus {

    Open("Открыт"), Closed("Закрыт"), ClosedForever("Закрыт навсегда");
    private String description;

    PeriodStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
