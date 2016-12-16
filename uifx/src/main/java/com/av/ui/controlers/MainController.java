package com.av.ui.controlers;

import com.av.domain.Model;
import com.av.domain.ifaces.INodeable;
import com.av.repositories.ModelService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 16.12.16.
 */


public class MainController implements Initializable {


    public MainController() {
        System.out.println("new");
    }

    private         TreeItem root = new TreeItem<>();
private  TreeItem model = new TreeItem<>("Модели");

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

@Autowired (required = true)

    ModelService modelService;


    private void press(KeyEvent keyEvent) {

        System.out.printf("бумс");

    }

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
                                setText(((INodeable) item).getNodelLable());
                            } else setText(item.toString());
                        }
                    }
                };
                return treeCell;
            }
        });

        init();

        mainTree.setRoot(root);
        mainTree.setShowRoot(true);
    }

    @PostConstruct
    //Контролер запускается 2 раза - надо думать
    public void init() {
        ObservableList<Model> models = modelService.getAll();

        models.forEach( m ->  {

            TreeItem<Model> modelTreeItem = new TreeItem<>(m);

            model.getChildren().addAll(modelTreeItem);

        });


        root.getChildren().addAll(model);




    }


    public void btnAddClicked(MouseEvent mouseEvent) {
        System.out.println("add new record");
    }
}
