package com.av.ui.controlers;

import com.av.domain.Model;
import com.av.domain.ifaces.INodeable;
import com.av.repositories.ModelService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
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
    private TreeItem model = new TreeItem<>("Модели");

    @FXML
    private BorderPane mainPane;

    @FXML
    private MenuButton menuBtAdd;

    @FXML
    private TreeView mainTree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initTree();

    }

    @Autowired()
    ModelService modelService;


    public void onExitClick(ActionEvent actionEvent) {

        Platform.exit();

    }

    private void initTree() {


        mainTree.setCellFactory(new Callback<TreeView, TreeCell>() {
            @Override
            public TreeCell call(TreeView param) {

                TreeCell treeCell = new TreeCell() {
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setText(null);
                        } else if (item != null) {
                            if (item instanceof INodeable) {
                                setText(((INodeable) item).getNodelLabel());
                            } else setText(item.toString());
                        }
                    }
                };
                return treeCell;
            }
        });

        ObservableList<Model> models = modelService.getAll();

        models.forEach(m -> {
            TreeItem<Model> modelTreeItem = new TreeItem<>(m);
            model.getChildren().addAll(modelTreeItem);
        });


        root.getChildren().addAll(model);

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
