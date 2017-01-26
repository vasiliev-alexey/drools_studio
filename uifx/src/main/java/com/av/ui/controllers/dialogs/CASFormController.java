package com.av.ui.controllers.dialogs;

import com.av.domain.accounting.ChartOfAccountStructure;
import com.av.domain.accounting.Event;
import com.av.domain.accounting.SegmentDescription;
import com.av.ui.controllers.AbstractController;
import com.av.ui.controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by vasiliev-alexey on 26.01.17.
 */
public class CASFormController extends AbstractController {


    @FXML
    public TableColumn descriptionColumn;
    @FXML
    public TableColumn positionColumn;
    @FXML
    public TextField countSegment;
    @FXML
    public TextField structCodeTxf;
    @FXML
    public TextField structNameTxf;
    @FXML
    public TableView segmentsTableView;
    public AnchorPane mainPane;

    private ChartOfAccountStructure structure;

    private ObservableList<SegmentDescription> segmentDescriptions;
    private Stage dialogStage;


    public void setDependencyValue(Stage dialogStage, ChartOfAccountStructure structure, boolean readOnly) {

        this.dialogStage = dialogStage;
        this.structure = structure;
        segmentDescriptions = FXCollections.observableArrayList(structure.getSegmentDescriptionList());


        bind();
    }

    private void bind() {

        structCodeTxf.textProperty().bindBidirectional(structure.codeProperty());
        structNameTxf.textProperty().bindBidirectional(structure.nameProperty());

        segmentDescriptions.addListener((ListChangeListener) c -> {
            countSegment.textProperty().setValue(Integer.toString(c.getList().size()));
        });
        countSegment.textProperty().setValue(Integer.toString(structure.getSegmentDescriptionList().size()));
        segmentsTableView.setItems(segmentDescriptions);

        positionColumn.prefWidthProperty().bind(segmentsTableView.prefWidthProperty().multiply(0.1));
        descriptionColumn.prefWidthProperty().bind(segmentsTableView.prefWidthProperty().multiply(0.9));
        segmentsTableView.prefWidthProperty().bind(mainPane.widthProperty());
     //   segmentsTableView.getColumns().forEach( c -> ((TableColumn)c).setSortable(false));



    }
    public void handleOk(ActionEvent actionEvent) {
    }

    public void handleCancel(ActionEvent actionEvent) {
    }

}
