package com.av.ui.controllers;


import com.av.data.services.ModelService;
import com.av.ui.factories.MainTreeCellFactory;
import com.av.ui.managers.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private ModelService modelService;

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
    @Autowired
    private AccountCalendarManager accountCalendarManager;
    @Autowired
    private CASManager casManager;


    @Autowired
    private CurrencyManager currencyManager;
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
        TreeItem<AbstractDataManager> eventTreeItem = new TreeItem<>();
        eventTreeItem.setValue(eventManager);

        TreeItem<AbstractDataManager> accountTreeItem = new TreeItem<>();
        accountTreeItem.setValue(new AccountingManager());

        TreeItem currencyItem = new TreeItem<>();
        currencyItem.setValue(currencyManager);

        TreeItem accountCalendarItem = new TreeItem();
        accountCalendarItem.setValue(accountCalendarManager);

        TreeItem<AbstractDataManager> casItem = new TreeItem<>();
        casItem.setValue(casManager);

        accountTreeItem.getChildren().addAll(currencyItem ,  eventTreeItem  ,accountCalendarItem , casItem);




        root.getChildren().addAll(modelTreeItem,accountTreeItem);

        mainTree.setRoot(root);
        mainTree.setShowRoot(false);
        splitpane.getItems().removeAll(downPanel);
        splitpane.getItems().addAll(bottomPane);

        // fix oracle jdk bug
        mainTree.setCellFactory( data -> new TreeCell<AbstractDataManager>(){
            @Override
            protected void updateItem(AbstractDataManager item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getLabel());
                setGraphic(empty ? null : item.getIcon());
            }
        });

        init();

    }

    @PostConstruct
    public void init() {
        modelEvent.setActionPane(actionPane);
        modelEvent.setBottomPane(bottomPane);
        modelEvent.setTopPanel(topPanel);


    }



}//