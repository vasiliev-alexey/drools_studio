package com.av.ui.controllers.dialogs;

import com.av.domain.accounting.ChartOfAccountStructure;
import com.av.domain.accounting.SegmentDescription;
import com.av.ui.controllers.AbstractController;
import com.av.ui.utils.Command;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

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

    private Command close;


    public void setDependencyValue(ChartOfAccountStructure structure, boolean readOnly , Command command) {
        this.close = command;
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
        Alert  alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Предупреждение");
        alert.setHeaderText("Сохранение не реализовано");

        alert.showAndWait();
        close.perform();

    }

    public void handleCancel(ActionEvent actionEvent) {

        close.perform();

    }

}
