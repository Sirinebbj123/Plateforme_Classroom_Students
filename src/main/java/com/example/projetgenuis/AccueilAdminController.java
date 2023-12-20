package com.example.projetgenuis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AccueilAdminController implements Initializable {
    @FXML
    private Button btn1GU;

    @FXML
    private Button btn2GC;

    @FXML
    private Button btn3GP;

    @FXML
    private Button btn4S;
    @FXML
    private ImageView im1;

    @FXML
    private ImageView im2;

    @FXML
    private ImageView im3;

    @FXML
    private ImageView im4;


    @FXML
    void handlebuttonclicks(ActionEvent event) {
        String fxml= "";
        Object source = event.getSource();
        if (source.equals(btn1GU)) {
            fxml = "gestionUtilisateur.fxml";
        } else if (source.equals(btn2GC)) {
            fxml = "cours.fxml";
        } else if (source.equals(btn3GP)) {
            fxml = "cours.fxml";
        } else if (source.equals(btn4S)) {
            fxml = "statistique.fxml";
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
        Image image1 = new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\remo3.png");
        im1.setImage(image1);
        Image image2 = new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\remo2.png");
        im2.setImage(image2);

        Image image3 = new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\remo1.png");
        im3.setImage(image3);

        Image image4 = new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\remo4.png");
        im4.setImage(image4);

    }
}
