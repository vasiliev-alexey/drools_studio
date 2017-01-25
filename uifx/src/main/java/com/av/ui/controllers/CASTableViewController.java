package com.av.ui.controllers;

import com.av.data.services.ChartOfAccountStructureService;
import com.av.domain.accounting.ChartOfAccountStructure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
public class CASTableViewController extends AbstractController implements Initializable {



    @FXML
    private TableView tableCAS;
    private ObservableList<ChartOfAccountStructure> casList = FXCollections.emptyObservableList();

    @Autowired
    private ChartOfAccountStructureService chartOfAccountStructureService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        casList = chartOfAccountStructureService.getAll();
        tableCAS.setItems(casList);
    }
}
