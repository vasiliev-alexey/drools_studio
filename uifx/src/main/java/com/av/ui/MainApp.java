package com.av.ui;/**
 * Created by alexey on 02.12.16.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Stage - это контейнер, ассоциированный с окном

        // Если вы загляните в файл sample.fxml, то у видете в нем XML объявление элемента GridPane, т.е. табличного контейнера
        // Этот контейнер мы будем считать корневым, т.е. все элементы нашего приложения будут содержаться в нем
        Parent root = null;
        try {
            root = FXMLLoader.load(MainApp.class.getClassLoader().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }



        // создаем сцену с заданными шириной и высотой и содержащую наш корневым контейнером, и связываем ее с окном
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show(); // запускаем окно
    }

}
