package com.example.projetgenuis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Gestiondeprogrès  implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Label label;
    public void display(ActionEvent event) {
        Path fileS= Paths.get("./fifi.txt");
        int compteurS = 0;
        try {
            Scanner scanner = new Scanner(fileS);

            while (scanner.hasNextLine()) {
                compteurS++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        label.setText("okiiii");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
