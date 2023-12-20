package com.example.projetgenuis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class conceptiontachesController implements Initializable {

    final ObservableList<tache> dataquiz= FXCollections.observableArrayList();

    final ObservableList<tache> datajt = FXCollections.observableArrayList();

    tache tacheSelect;
    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupprime;

    @FXML
    private Button ajout1;

    @FXML
    private TableColumn<tache, Integer> colquiz1;

    @FXML
    private TableColumn<tache, Integer> colquiz2;

    @FXML
    private TableColumn<tache, Integer> colquiz3;

    @FXML
    private TableColumn<tache, String> ddncol;

    @FXML
    private TableColumn<tache, String> idcol;

    @FXML
    private TableColumn<tache, String> mailcol;

    @FXML
    private TableColumn<tache, String> nomcol;

    @FXML
    private TableColumn<tache, String> prenomcol;

    @FXML
    private TableColumn<tache, Integer> quizsomme;

    @FXML
    private TableView<tache> table;
    @FXML
    private TableView<tache> table2;
    @FXML
    private TextField f1;

    @FXML
    private TextField f2;

    @FXML
    private TextField f3;
    @FXML
    private TextField f4;

    @FXML
    private TextField txtaj1;


    private void saveapprenantinfile(tache t) {
        //  String xx= String.valueOf(a.hashCode());a.getId()+","+","+
        String s =t.getId()+","+t.getNom() + "," +t.getPrenom() + "," +t.getDatedenaissance() + "," +t.getAdressemail()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./fichierconception.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    private void readapprenant() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./fichierconception.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                tache t = new tache();
                t.setId(fields[0]);
                t.setNom(fields[1]);
                t.setPrenom(fields[2]);
                t.setDatedenaissance(fields[3]);
                t.setAdressemail(fields[4]);
                //  t.setQuiz1(Integer.valueOf(fields[5]));
                //t.setQuiz2(Integer.valueOf(fields[6]));
                //t.setQuiz3(Integer.valueOf(fields[7]));
                //t.setSomme(Integer.valueOf(fields[8]));
                this.datajt.add(t);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveapprenantinfilee(tache t) {
        //  String xx= String.valueOf(a.hashCode());a.getId()+","+","+
        String s =t.getQuiz1()+","+t.getQuiz2() + "," + t.getQuiz3()+","+t.getSomme()+"\n";
        byte data[] = s.getBytes();
        Path p = Paths.get("./quizesconception.txt");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    private void readapprenantt() {
        Path file = Paths.get("./quizesconception.txt");
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tache t = new tache();
                // a.setId(String.valueOf(a.hashCode()));
                String sp[] = line.split(",");
                t.setQuiz1(Integer.valueOf(sp[0]));
                t.setQuiz2(Integer.valueOf(sp[1]));
                t.setQuiz3(Integer.valueOf(sp[2]));
                if(Integer.valueOf(sp[3])<=100){
                t.setSomme(Integer.valueOf(sp[3]));}

                this.dataquiz.add(t);
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);}
    }


    @FXML
    void ajoutaches(ActionEvent event) {
        tache t=new tache();

        t.setQuiz1(Integer.valueOf(f1.getText()));
        t.setQuiz2(Integer.valueOf(f2.getText()));
        t.setQuiz3(Integer.valueOf(f3.getText()));

        int s= (Integer.parseInt(f1.getText()) ) + (Integer.parseInt(f2.getText()) )+(Integer.parseInt(f3.getText()) );
        t.setSomme(Integer.valueOf(s));
        dataquiz.add(t);
        saveapprenantinfilee(t);

    }

    @FXML
    void modifierquiz(ActionEvent event) {
        tache selectedTache = table2.getSelectionModel().getSelectedItem();
        if (selectedTache != null) {
            int s = Integer.parseInt(f1.getText()) + Integer.parseInt(f2.getText()) + Integer.parseInt(f3.getText());
            selectedTache.setQuiz1(Integer.valueOf(f1.getText()));
            selectedTache.setQuiz2(Integer.valueOf(f2.getText()));
            selectedTache.setQuiz3(Integer.valueOf(f3.getText()));
            selectedTache.setSomme(s);
            saveapprenantinfilee(selectedTache);
            table2.refresh();
        }

    }

    @FXML
    void supprimerquiz(ActionEvent event) {
        this.dataquiz.remove(tacheSelect);
        tacheSelect= null;

    }





    @FXML
    void rowClickedd(MouseEvent event) {

        tache clickedApp = table2.getSelectionModel().getSelectedItem();
        f1.setText(String.valueOf(clickedApp.getQuiz1()));
        f2.setText(String.valueOf(clickedApp.getQuiz2()));
        f3.setText(String.valueOf(clickedApp.getQuiz3()));


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        readapprenantt();
        readapprenant();


        this.idcol.setCellValueFactory(new PropertyValueFactory<tache,String>("id"));
        this.nomcol.setCellValueFactory(new PropertyValueFactory<tache, String>("nom"));
        this.prenomcol.setCellValueFactory(new PropertyValueFactory<tache, String>("prenom"));
        this.ddncol.setCellValueFactory(new PropertyValueFactory<tache, String>("datedenaissance"));
        this.mailcol.setCellValueFactory(new PropertyValueFactory<tache, String>("adressemail"));

        table.setItems(datajt);

        colquiz1.setCellValueFactory(new PropertyValueFactory<tache,Integer>("quiz1"));
        colquiz2.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz2"));
        colquiz3.setCellValueFactory(new PropertyValueFactory<tache,Integer>("quiz3"));
        quizsomme.setCellValueFactory(new PropertyValueFactory<tache,Integer>("somme"));
        table2.setItems(dataquiz);
        ///
        this.table2.getSelectionModel().selectedIndexProperty().addListener(a -> {
            tacheSelect = table2.getSelectionModel().getSelectedItem();
            this.f1.setText(String.valueOf(tacheSelect.getQuiz1()));
            this.f2.setText(String.valueOf(tacheSelect.getQuiz2()));
            this.f3.setText(String.valueOf(tacheSelect.getQuiz3()));
            this.f4.setText(String.valueOf(tacheSelect.getSomme()));


        });





    }


    public void rowClicked(MouseEvent mouseEvent) {
    }
    }


