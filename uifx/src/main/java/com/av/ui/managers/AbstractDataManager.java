package com.av.ui.managers;

import javafx.scene.control.TableSelectionModel;

import javax.persistence.Table;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public abstract class AbstractDataManager<T>  implements StandardAction<T>{


    protected TableSelectionModel<T>  tableSelectionModel;


    protected String  viewName;





    public abstract String getLabel() ;
    public abstract String getViewName();
}
