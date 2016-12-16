package com.av.ui;/**
 * Created by alexey on 02.12.16.
 */

import com.av.ui.controlers.MainController;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {

       ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:repository-beans.xml");

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) {
        // Stage - это контейнер, ассоциированный с окном

        // Этот контейнер мы будем считать корневым, т.е. все элементы нашего приложения будут содержаться в нем
       /*
        Parent root = null;
        try {
            root = FXMLLoader.load(MainApp.class.getClassLoader().getResource("fxml/Main.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        MainController controller = (MainController) SpringFXMLLoader.load("/fxml/Main.fxml");
        Scene root = new Scene((Parent) controller.getView(), 300, 275);



        // создаем сцену с заданными шириной и высотой и содержащую наш корневым контейнером, и связываем ее с окном
        primaryStage.setScene(root);

        Screen screen = Screen.getPrimary();
        primaryStage.setHeight(screen.getBounds().getHeight());
        primaryStage.setWidth(screen.getBounds().getWidth());


        primaryStage.setTitle("Струдия настройки бизнес правил учета");
        primaryStage.show(); // запускаем окно
    }

}
