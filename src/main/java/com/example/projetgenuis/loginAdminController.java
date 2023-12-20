package com.example.projetgenuis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginAdminController  implements Initializable {
    @FXML
    private ImageView admin;
    @FXML
    private TextField btn1;

    @FXML
    private TextField btn2;

    @FXML
    private Button btnconnecter;
    @FXML
    void switch1(ActionEvent event) {

        if((btn1.getText().equals("admin"))&&(btn2.getText().equals("admin"))){
        String fxml= "";
        Object source = event.getSource();
        if (source.equals(btnconnecter)) {
            fxml = "AccueilAdmin.fxml";
        }
        loadStage(fxml);}

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

    public void handlebuttonclicks(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image i1=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\resources\\com\\example\\projetgenuis\\admino-removebg-preview.png");
        admin.setImage(i1);
    }
}
