package com.av.ui.managers;

import com.av.domain.accounting.ChartOfAccountStructure;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
@Service
@Lazy
public class CASManager extends AbstractDataManager<ChartOfAccountStructure> {
    private static Logger logger = Logger.getLogger(CASManager.class.getName());

    @Override
    public ChartOfAccountStructure addItem() {
        return null;
    }

    @Override
    public String getLabel() {
        return "Структура плана счетов";
    }

    @Override
    public String getViewName() {
        return "/fxml/tableviews/CASTableView.fxml";
    }

    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/structure_16x16.png")));
    }
}
