package com.av.ui.controllers;

import com.av.repositories.ModelService;
import com.av.ui.treeitems.ModelTreeItem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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


public class MainController implements Initializable, Controller {
    private Node view;


    private TreeItem root = new TreeItem<>();
   // private TreeItem model = new TreeItem<>("Модели");
   ModelTreeItem modelTreeItem = new ModelTreeItem();

    @FXML
    private BorderPane mainPane;

    @FXML
    private MenuButton menuBtAdd;

    @FXML
    private TreeView mainTree;
    @FXML
    private AnchorPane topPanel;

    @FXML
    private AnchorPane actionPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initTree();

    }

    @Autowired()
    ModelService modelService;


    public void onExitClick(ActionEvent actionEvent) {

        Platform.exit();

    }

    /**
     * Метод заполняет дерево в навигационной пенели
     *
     */
    private void initTree() {


        mainTree.setCellFactory(new MainTreeCellFactory());

        mainTree.setOnMouseClicked(new TreeModelEvent(actionPane , topPanel));

        root.getChildren().addAll(modelTreeItem);

        mainTree.setRoot(root);
        mainTree.setShowRoot(false);


    }

    @PostConstruct
    public void init() {


    }

    public Node getView() {
        return view;
    }

    public void setView(Node view) {
        this.view = view;
    }

    public void btnAddClicked(MouseEvent mouseEvent) {
        System.out.println("add new record");
    }
}
