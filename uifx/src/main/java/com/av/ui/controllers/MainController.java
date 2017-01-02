package com.av.ui.controllers;

import com.av.repositories.ModelService;
import com.av.ui.factories.MainTreeCellFactory;
import com.av.ui.managers.EventManager;
import com.av.ui.managers.ModelManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 16.12.16.
 */


public class MainController extends AbstractController implements Initializable {
    @Autowired()
    ModelService modelService;
    // private TreeItem model = new TreeItem<>("Модели");
    //  ModelTreeItem modelTreeItem = new ModelTreeItem();
    private TreeItem root = new TreeItem<>();
    @FXML
    private BorderPane mainPane;
    @FXML
    private MenuButton menuBtAdd;
    @FXML
    private TreeView mainTree;
    @FXML
    private AnchorPane topPanel;
    @FXML
    @Autowired
    private AnchorPane bottomPane;
    @FXML
    private AnchorPane actionPane;
    @Autowired
    private TreeModelEvent modelEvent;
    @Autowired
    private ModelManager modelManager;
    @Autowired
    private EventManager eventManager;
    @FXML
    private AnchorPane downPanel;
    @FXML
    private SplitPane splitpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initTree();

    }

    public void onExitClick(ActionEvent actionEvent) {

        Platform.exit();

    }

    /**
     * Метод заполняет дерево в навигационной пенели
     */
    private void initTree() {


        mainTree.setCellFactory(new MainTreeCellFactory());

        mainTree.setOnMouseClicked(modelEvent);
        TreeItem<ModelManager> modelTreeItem = new TreeItem<ModelManager>();

        modelTreeItem.setValue(modelManager);







        TreeItem<EventManager> eventTreeItem = new TreeItem<>();
        eventTreeItem.setValue(eventManager);


        root.getChildren().addAll(modelTreeItem, eventTreeItem);

        mainTree.setRoot(root);
        mainTree.setShowRoot(false);
        splitpane.getItems().removeAll(downPanel);
        splitpane.getItems().addAll(bottomPane);

        init();

    }

    @PostConstruct
    public void init() {
        modelEvent.setActionPane(actionPane);
        modelEvent.setBottomPane(bottomPane);
        modelEvent.setTopPanel(topPanel);


    }


    public void btnAddClicked(MouseEvent mouseEvent) {
        System.out.println("add new record");
    }
}//