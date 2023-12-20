package com.example.projetgenuis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.transformation.FilteredList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class gestionUtilisateurController    implements Initializable {
    final ObservableList<Apprenant> data = FXCollections.observableArrayList();
    final ObservableList<Apprenant> dataj = FXCollections.observableArrayList();

    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnbdd;

    @FXML
    private Button btnconception;

    @FXML
    private Button btnjava;
    @FXML
    private Button btnweb;
    @FXML
    private ImageView user;
    @FXML
    private TableColumn<Apprenant, String> courcol;
    @FXML
    private TableColumn<Apprenant, String> ddncol;
    @FXML
    private TableColumn<Apprenant, String> idcol;
    @FXML
    private TableColumn<Apprenant, String> mailcol;
    @FXML
    private TableColumn<Apprenant, String> nomcol;
    @FXML
    private TableColumn<Apprenant, String> prenomcol;
    @FXML
    private TableView<Apprenant> table;
    @FXML
    private TextField txtddn;
    @FXML
    private TextField txtmail;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtrechercher;
    @FXML
    private TextField txtid;
    Apprenant apprenantSelect;
    ObservableList<Apprenant> apprenantList;
    private void saveapprenantinfile(Apprenant a) {
      //  String xx= String.valueOf(a.hashCode());a.getId()+","+","+
        String s =a.getId()+","+a.getNom() + "," + a.getPrenom() + "," + a.getDatedenaissance() + "," + a.getAdressemail()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./all.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
   /* public void getDate(ActionEvent event){
        LocalDate mydate=txtddn
    }*/

    ///dima mawjoud f tableview
    private void readapprenant() {
        Path file = Paths.get("./all.txt");

        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Apprenant a = new Apprenant();
               // a.setId(String.valueOf(a.hashCode()));
                String sp[] = line.split(",");
                a.setId(sp[0]);
                a.setNom(sp[1]);
                a.setPrenom(sp[2]);
                a.setDatedenaissance(sp[3]);
                a.setAdressemail(sp[4]);
                this.data.add(a);
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);}
    }

   @FXML
    private void ajouter(ActionEvent event) {
       String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
               + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
       Pattern pattern = Pattern.compile(masque);
       Matcher controler = pattern.matcher(txtmail.getText());
if(txtnom.getText().isEmpty()|| txtprenom.getText().isEmpty()||txtddn.getText().isEmpty()||txtmail.getText().isEmpty())
{Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("error message");
    alert.setHeaderText(null);
    alert.setContentText("le champs ne doit pas etre vide");
    alert.showAndWait();
       }
       else if(txtnom.getText().matches("[a-zA-Z']*")!=true||txtnom.getText().matches("[a-zA-Z']*")!=true){

    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("error message");
    alert.setHeaderText(null);
    alert.setContentText("ca champ comporte les lettres a-z et ' ctt");
    alert.showAndWait();
} else if (txtnom.getText().length()<3 ||txtprenom.getText().length()<3  ) {
    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("error message");
    alert.setHeaderText(null);
    alert.setContentText("nom,prenom de lengeur>=3");
    alert.showAndWait();
    
} else if (controler.matches()==false) {

    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("error message");
    alert.setHeaderText(null);
    alert.setContentText("adresse mail non  valide");
    alert.showAndWait();
    
} else{
        Apprenant apprenant = new Apprenant();
         txtid.setText(String.valueOf(apprenant.hashCode()));
         apprenant.setId(txtid.getText());
        apprenant.setNom(txtnom.getText());
        apprenant.setPrenom(txtprenom.getText());
        apprenant.setDatedenaissance(txtddn.getText());
        apprenant.setAdressemail(txtmail.getText());
    boolean emailUnique = true;
    for (Apprenant a : data) {
        if (a.getAdressemail().equals(apprenant.getAdressemail())) {
            emailUnique = false;
            break;
        }
    }
    if (!emailUnique) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Adresse e-mail déjà utilisée !");
        alert.showAndWait();
        return;
    }
    data.add(apprenant);
        saveapprenantinfile(apprenant);
       }

    }
    @FXML
    void actionbdd(ActionEvent event) {
        this.dataj.add(apprenantSelect);
        String s =apprenantSelect.getId()+","+apprenantSelect.getNom() + "," + apprenantSelect.getPrenom() + "," + apprenantSelect.getDatedenaissance() + "," + apprenantSelect.getAdressemail()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./fichierbdd.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    @FXML
    void actionconception(ActionEvent event) {
        this.dataj.add(apprenantSelect);
        String s =apprenantSelect.getId()+","+apprenantSelect.getNom() + "," + apprenantSelect.getPrenom() + "," + apprenantSelect.getDatedenaissance() + "," + apprenantSelect.getAdressemail()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./fichierconception.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }

    }



    @FXML
    void actionweb(ActionEvent event) {
        this.dataj.add(apprenantSelect);
        String s =apprenantSelect.getId()+","+apprenantSelect.getNom() + "," + apprenantSelect.getPrenom() + "," + apprenantSelect.getDatedenaissance() + "," + apprenantSelect.getAdressemail()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./fichierweb.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    @FXML
    void actionjava(ActionEvent event) {
        this.dataj.add(apprenantSelect);
        String s =apprenantSelect.getId()+","+apprenantSelect.getNom() + "," + apprenantSelect.getPrenom() + "," + apprenantSelect.getDatedenaissance() + "," + apprenantSelect.getAdressemail()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./fichierjava.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }



    @FXML
    void modifier(ActionEvent event) {
       ObservableList<Apprenant> currentdata = table.getItems();
          String curram=txtmail.getText();
        for (Apprenant apprenant : currentdata) {

            if (apprenant.getAdressemail().equals(curram)) {
                apprenant.setNom(txtnom.getText());
                apprenant.setPrenom(txtprenom.getText());
                apprenant.setDatedenaissance(txtddn.getText());
                table.setItems(currentdata);
    saveapprenantinfile(apprenant);
                table.refresh();
                break;}}
        }
   @FXML
    void rowClicked(MouseEvent event) {

       Apprenant clickedApp = table.getSelectionModel().getSelectedItem();

       txtnom.setText(String.valueOf(clickedApp.getNom()));
       txtprenom.setText(String.valueOf(clickedApp.getPrenom()));
       txtddn.setText(String.valueOf(clickedApp.getDatedenaissance()));
       txtmail.setText(String.valueOf(clickedApp.getAdressemail()));

   }




        @FXML
        void supprimer (ActionEvent event){
            this.data.remove(apprenantSelect);
            apprenantSelect = null;
            this.btnsupprimer.setDisable(true);
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Image i1=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\java\\com\\example\\projetgenuis\\ahla-removebg-preview.png");
        user.setImage(i1);



        readapprenant();
        this.btnsupprimer.setDisable(true);
        this.btnmodifier.setDisable(true);

        apprenantList = FXCollections.observableArrayList();

       // this.table.setItems(data);
        //  HashSet<Integer> mapapp= new HashSet<Integer>();

        Set<Apprenant>appset=new HashSet<>();

        idcol.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("id"));
        nomcol.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("prenom"));
        ddncol.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("datedenaissance"));
        mailcol.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("adressemail"));
        //    courcol.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("cours"));

       table.setItems(data);

        this.table.getSelectionModel().selectedIndexProperty().addListener(a -> {
            apprenantSelect = table.getSelectionModel().getSelectedItem();
            this.btnsupprimer.setDisable(false);
            this.btnmodifier.setDisable(false);
            this.txtid.setText(apprenantSelect.getId());
            this.txtnom.setText(apprenantSelect.getNom());
            this.txtprenom.setText(apprenantSelect.getPrenom());
            this.txtddn.setText(apprenantSelect.getDatedenaissance());
            this.txtmail.setText(apprenantSelect.getAdressemail());

        });
        //////////////rechercher
        FilteredList<Apprenant> filteredList = new FilteredList<>(data, b -> true);

        txtrechercher.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredList.setPredicate(Apprenant -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (Apprenant.getNom().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Apprenant.getPrenom().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Apprenant.getDatedenaissance().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Apprenant.getAdressemail().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else return false;
            });
        });
        SortedList<Apprenant> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedList);



    }

}






