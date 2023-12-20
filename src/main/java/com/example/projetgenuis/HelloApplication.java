package com.example.projetgenuis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class HelloApplication extends Application implements Initializable {

    private double x,y;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("GINUISPROG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        launch();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}