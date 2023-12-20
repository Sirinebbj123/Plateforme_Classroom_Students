module com.example.projetgenuis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.projetgenuis to javafx.fxml;
    exports com.example.projetgenuis;
}