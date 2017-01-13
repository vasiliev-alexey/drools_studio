package com.av.domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by vasiliev-alexey on 02.01.17.
 */
public class Error {

    private StringProperty errType;
    private StringProperty errMessage;

    public Error(String errType, String errMessage) {
        this.errType = new SimpleStringProperty(errType);
        this.errMessage =  new SimpleStringProperty(errMessage);
    }

    public String getErrMessage() {
        return errMessage.get();
    }

    public StringProperty errMessageProperty() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage.set(errMessage);
    }

    public String getErrType() {
        return errType.get();
    }

    public StringProperty errTypeProperty() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType.set(errType);
    }
}
