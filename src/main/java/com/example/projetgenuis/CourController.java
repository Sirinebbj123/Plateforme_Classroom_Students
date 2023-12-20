package com.example.projetgenuis;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourController implements Initializable {
    @FXML
    private ImageView webc;

    @FXML
    private ImageView javac;
    @FXML
    private ImageView bddc;

    @FXML
    private ImageView cncpc;


    @FXML
    private Button bddbtn;

    @FXML
    private Button conceptionbtn;

    @FXML
    private Button javabtn;

    @FXML
    private Button webbtn;
   @FXML
    void opo(ActionEvent event) {
        String fxml= "";
        Object source = event.getSource();
        if (source.equals(javabtn)) {
            fxml = "javatache.fxml";
        } else if (source.equals(conceptionbtn)) {
            fxml = "conceptiontaches.fxml";
        } else if (source.equals(bddbtn)) {
            fxml = "bddtaches.fxml";
        } else if (source.equals(webbtn)) {
            fxml = "webtaches.fxml";
        }
        loadStage(fxml);

    }



    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image java=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\java-removebg-preview.png");
        javac.setImage(java);
        Image web=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\webb-removebg-preview.png");
        webc.setImage(web);
        Image conception=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\conception-removebg-preview.png");
        cncpc.setImage(conception);
        Image bdd=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\basedd-removebg-preview.png");
        bddc.setImage(bdd);

    }
}
