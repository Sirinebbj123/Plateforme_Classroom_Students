package com.example.projetgenuis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.*;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.w3c.dom.Text;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;


public class statistiquesController implements Initializable {
    @FXML
    private ImageView stat;
    final ObservableList<tache> data = FXCollections.observableArrayList();
    final ObservableList<tache> dataC = FXCollections.observableArrayList();
    final ObservableList<tache> dataW = FXCollections.observableArrayList();
    final ObservableList<tache> dataB = FXCollections.observableArrayList();

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button button;
///////////////////////////////////////////////////////////////////////////
    @FXML
    private TableView<tache> table1;
    @FXML
    private TableColumn<tache,String> idcol;
    @FXML
    private TableColumn<tache,String> nomcol1;
    @FXML
    private TableColumn<tache,String> prencol1;
    @FXML
    private TableColumn<tache,String> dncol1;
    @FXML
    private TableColumn<tache,String> amcol1;
    @FXML
    private TableColumn<tache, Integer> colquiz11;
    @FXML
    private TableColumn<tache, Integer> colquiz21;
    @FXML
    private TableColumn<tache, Integer> colquiz31;
    @FXML
    private TableColumn<tache, Integer> colquizsomme1;
    ////////////////////////////////////////////////////////////////////////

    @FXML
    private TableView<tache> table2;
    @FXML
    private TableColumn<tache,String> idcol2;
    @FXML
    private TableColumn<tache,String> nomcol2;
    @FXML
    private TableColumn<tache,String> prencol2;
    @FXML
    private TableColumn<tache,String> dncol2;
    @FXML
    private TableColumn<tache,String> amcol2;
    @FXML
    private TableColumn<tache, Integer> colquiz12;
    @FXML
    private TableColumn<tache, Integer> colquiz22;
    @FXML
    private TableColumn<tache, Integer> colquiz32;
    @FXML
    private TableColumn<tache, Integer> colquizsomme2;

    ///////////////////////////////////////////////////////

    @FXML
    private TableView<tache> table3;

    @FXML
    private TableColumn<tache,String> idcol3;
    @FXML
    private TableColumn<tache,String> nomcol3;
    @FXML
    private TableColumn<tache,String> prencol3;
    @FXML
    private TableColumn<tache,String> dncol3;
    @FXML
    private TableColumn<tache,String> amcol3;
    @FXML
    private TableColumn<tache, Integer> colquiz13;
    @FXML
    private TableColumn<tache, Integer> colquiz23;
    @FXML
    private TableColumn<tache, Integer> colquiz33;
    @FXML
    private TableColumn<tache, Integer> colquizsomme3;

    //////////////////////////////////////////////////
    @FXML
    private TableView<tache> table4;
    @FXML
    private TableColumn<tache,String> idcol4;
    @FXML
    private TableColumn<tache,String> nomcol4;
    @FXML
    private TableColumn<tache,String> prencol4;
    @FXML
    private TableColumn<tache,String> dncol4;
    @FXML
    private TableColumn<tache,String> amcol4;
    @FXML
    private TableColumn<tache, Integer> colquiz14;
    @FXML
    private TableColumn<tache, Integer> colquiz24;
    @FXML
    private TableColumn<tache, Integer> colquiz34;

    @FXML
    private TableColumn<tache, Integer> colquizsomme4;
    @FXML
    private Text txt;
    @FXML
    private Button btn1;
    @FXML
    private TextField txt2;
    @FXML
    private Button btn3;
    @FXML
    private Label lab1;


    private Scanner scanner;

    @FXML
    void handleclose(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void btnaj(ActionEvent event) {
        txt.setData("syrine");
    }

    @FXML
    void handleshowbarchat(ActionEvent event) {
        CategoryAxis xA = new CategoryAxis();
        xA.setLabel("nombre de participants à chaque cours");
        NumberAxis yA = new NumberAxis();
        yA.setLabel("nombre apprenants");
        BarChart barChart = new BarChart<>(xA, yA);
        XYChart.Series data = new XYChart.Series();
        data.setName("name");
        barChart.setStyle("-fx-bar-fill: blue;");
        ///////////////////////////////////////////////////////JAVA
        Path filJ = Paths.get("./fichierjava.txt");
        int compteurJ = 0;
        try {
            Scanner scanner = new Scanner(filJ);

            while (scanner.hasNextLine()) {
                compteurJ++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //////////////////////////////////////////////////////////CONCEPTION
        Path fileC = Paths.get("./fichierconception.txt");
        int compteurC = 0;
        try {
            Scanner scanner = new Scanner(fileC);

            while (scanner.hasNextLine()) {
                compteurC++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
////////////////////////////////////////////////////////web
        Path fileW = Paths.get("./fichierweb.txt");
        int compteurW = 0;
        try {
            Scanner scanner = new Scanner(fileW);

            while (scanner.hasNextLine()) {
                compteurW++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /////////////////////////////////////////////////////////bdd
        Path filebdd = Paths.get("./fichierbdd.txt");
        int compteurbdd = 0;
        try {
            Scanner scanner = new Scanner(filebdd);

            while (scanner.hasNextLine()) {
                compteurbdd++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ////////////////////////////////////////////////////////////
        data.getData().add(new XYChart.Data<>("java", compteurJ));
        data.getData().add(new XYChart.Data<>("conception", compteurC));
        data.getData().add(new XYChart.Data<>("web", compteurW));
        data.getData().add(new XYChart.Data<>("bdd", compteurbdd));
        barChart.getData().add(data);
        barChart.setLegendVisible(false);
        borderPane.setCenter(barChart);


    }

    @FXML
    void handleshowpiechart(ActionEvent event) {
        ///////////////////////////////////////////////////////JAVA
        Path filJ = Paths.get("./fichierjava.txt");
        int compteurJ = 0;
        try {
            Scanner scanner = new Scanner(filJ);

            while (scanner.hasNextLine()) {
                compteurJ++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //////////////////////////////////////////////////////////CONCEPTION
        Path fileC = Paths.get("./fichierconception.txt");
        int compteurC = 0;
        try {
            Scanner scanner = new Scanner(fileC);

            while (scanner.hasNextLine()) {
                compteurC++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
////////////////////////////////////////////////////////web
        Path fileW = Paths.get("./fichierweb.txt");
        int compteurW = 0;
        try {
            Scanner scanner = new Scanner(fileW);

            while (scanner.hasNextLine()) {
                compteurW++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /////////////////////////////////////////////////////////bdd
        Path filebdd = Paths.get("./fichierbdd.txt");
        int compteurbdd = 0;
        try {
            Scanner scanner = new Scanner(filebdd);

            while (scanner.hasNextLine()) {
                compteurbdd++;
                scanner.nextLine();

            }
            scanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("cour Java", compteurJ),
                new PieChart.Data("cour Conception", compteurC),
                new PieChart.Data("cour BDD", compteurbdd),
                new PieChart.Data("cour WEB", compteurW)

        );
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("statistique des cours");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);
        borderPane.setCenter(pieChart);
    }

    @FXML
    void handeupdate(ActionEvent event) {
        Node node = borderPane.getCenter();
        if (node instanceof PieChart) {
            PieChart pc = (PieChart) node;
            pc.getData().get(4).setPieValue(10);
        }
    }


    @FXML
    private Label tot;


    @FXML
    private void setOnAction() {

        Path fileS= Paths.get("./all.txt");
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

tot.setText(String.valueOf(compteurS));
    }
/*
@FXML
    JTextField affichesomme;*/

    private void sauvegarderdatajava() {
        Path infoFile = Paths.get("./fichierjava.txt");
        Path quizFile = Paths.get("./quizesjava.txt");
        try (InputStream infoIn = Files.newInputStream(infoFile);
             BufferedReader infoReader =
                     new BufferedReader(new InputStreamReader(infoIn));
             InputStream quizIn = Files.newInputStream(quizFile);
             BufferedReader quizReader =
                     new BufferedReader(new InputStreamReader(quizIn));
             PrintWriter writer = new PrintWriter(new FileWriter("./newfilej.txt"))) {
            String infoLine = infoReader.readLine();
            String quizLine = quizReader.readLine();
            while (infoLine != null && quizLine != null) {
                String newLine = infoLine + "," + quizLine;

                writer.println(newLine);

                System.out.println(newLine);

                infoLine = infoReader.readLine();
                quizLine = quizReader.readLine();
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }



    public String findMaxSommejava() {
        int maxSomme = Integer.MIN_VALUE;
        String maxLine = "";
        Path file = Paths.get("./newfilej.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] spJ = line.split(",");
                int somme = Integer.parseInt(spJ[8]);
                if (somme > maxSomme) {
                    maxSomme = somme;
                    maxLine = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxLine;
    }
    private void sauvegarderdataConception() {
        Path infoFile = Paths.get("./fichierconception.txt");
        Path quizFile = Paths.get("./quizesconception.txt");
        try (InputStream infoIn = Files.newInputStream(infoFile);
             BufferedReader infoReader =
                     new BufferedReader(new InputStreamReader(infoIn));
             InputStream quizIn = Files.newInputStream(quizFile);
             BufferedReader quizReader =
                     new BufferedReader(new InputStreamReader(quizIn));
             PrintWriter writer = new PrintWriter(new FileWriter("./newfileConception.txt"))) {
            String infoLine = infoReader.readLine();
            String quizLine = quizReader.readLine();
            while (infoLine != null && quizLine != null) {
                String newLine = infoLine + "," + quizLine;

                writer.println(newLine);

                System.out.println(newLine);

                infoLine = infoReader.readLine();
                quizLine = quizReader.readLine();
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    public String findMaxSommeConception() {
        int maxSomme = Integer.MIN_VALUE;
        String maxLineC= "";
        Path file = Paths.get("./newfileConception.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] spC = line.split(",");
                int somme = Integer.parseInt(spC[8]);
                if (somme > maxSomme) {
                    maxSomme = somme;
                    maxLineC = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxLineC;
    }
    private void sauvegarderdataWeb() {
        Path infoFile = Paths.get("./fichierweb.txt");
        Path quizFile = Paths.get("./quizesweb.txt");
        try (InputStream infoIn = Files.newInputStream(infoFile);
             BufferedReader infoReader =
                     new BufferedReader(new InputStreamReader(infoIn));
             InputStream quizIn = Files.newInputStream(quizFile);
             BufferedReader quizReader =
                     new BufferedReader(new InputStreamReader(quizIn));
             PrintWriter writer = new PrintWriter(new FileWriter("./newfileweb.txt"))) {
            String infoLine = infoReader.readLine();
            String quizLine = quizReader.readLine();
            while (infoLine != null && quizLine != null) {
                String newLine = infoLine + "," + quizLine;

                writer.println(newLine);

                System.out.println(newLine);

                infoLine = infoReader.readLine();
                quizLine = quizReader.readLine();
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }


    public String findMaxSommeWeb() {
        int maxSomme = Integer.MIN_VALUE;
        String maxLineW = "";
        Path file = Paths.get("./newfileweb.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] spW = line.split(",");
                int somme = Integer.parseInt(spW[8]);
                if (somme > maxSomme) {
                    maxSomme = somme;
                    maxLineW= line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxLineW;
    }
    private void sauvegarderdataBdd() {
        Path infoFile = Paths.get("./fichierbdd.txt");
        Path quizFile = Paths.get("./quizesbdd.txt");
        try (InputStream infoIn = Files.newInputStream(infoFile);
             BufferedReader infoReader =
                     new BufferedReader(new InputStreamReader(infoIn));
             InputStream quizIn = Files.newInputStream(quizFile);
             BufferedReader quizReader =
                     new BufferedReader(new InputStreamReader(quizIn));
             PrintWriter writer = new PrintWriter(new FileWriter("./newfilebdd.txt"))) {
            String infoLine = infoReader.readLine();
            String quizLine = quizReader.readLine();
            while (infoLine != null && quizLine != null) {
                String newLine = infoLine + "," + quizLine;

                writer.println(newLine);

                System.out.println(newLine);

                infoLine = infoReader.readLine();
                quizLine = quizReader.readLine();
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    public String findMaxSommeBdd() {
        int maxSomme = Integer.MIN_VALUE;
        String maxLineB = "";
        Path file = Paths.get("./newfilebdd.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] spB = line.split(",");
                int somme = Integer.parseInt(spB[8]);
                if (somme > maxSomme) {
                    maxSomme = somme;
                    maxLineB = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxLineB;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        javafx.scene.image.Image i1=new Image("C:\\Users\\Sirine\\IdeaProjects\\ProjetGenuisVA\\src\\main\\resources\\com\\example\\projetgenuis\\statttttttttttttttttttttt-removebg-preview.png");
        stat.setImage(i1);
        sauvegarderdatajava();
        sauvegarderdataConception();
        sauvegarderdataWeb();
        sauvegarderdataBdd();
//////////////////////////////////////////////////////////////javaaaa
        idcol.setCellValueFactory(new PropertyValueFactory<tache, String>("id"));
        nomcol1.setCellValueFactory(new PropertyValueFactory<tache, String>("nom"));
        prencol1.setCellValueFactory(new PropertyValueFactory<tache, String>("prenom"));
        dncol1.setCellValueFactory(new PropertyValueFactory<tache, String>("datedenaissance"));
        amcol1.setCellValueFactory(new PropertyValueFactory<tache, String>("adressemail"));
        colquiz11.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz1"));
        colquiz21.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz2"));
        colquiz31.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz3"));
        colquizsomme1.setCellValueFactory(new PropertyValueFactory<tache, Integer>("somme"));
////////////
        String maxLine = findMaxSommejava();
        String[] spJ = maxLine.split(",");
        tache maxTache = new tache();
        maxTache.setId(spJ[0]);
        maxTache.setNom(spJ[1]);
        maxTache.setPrenom(spJ[2]);
        maxTache.setDatedenaissance(spJ[3]);
        maxTache.setAdressemail(spJ[4]);
        maxTache.setQuiz1(Integer.parseInt(spJ[5]));
        maxTache.setQuiz2(Integer.parseInt(spJ[6]));
        maxTache.setQuiz3(Integer.parseInt(spJ[7]));
        maxTache.setSomme(Integer.parseInt(spJ[8]));
        data.add(maxTache);
        table1.setItems(data);


        /////////////////////////////////////////conception

        idcol2.setCellValueFactory(new PropertyValueFactory<tache, String>("id"));
        nomcol2.setCellValueFactory(new PropertyValueFactory<tache, String>("nom"));
        prencol2.setCellValueFactory(new PropertyValueFactory<tache, String>("prenom"));
        dncol2.setCellValueFactory(new PropertyValueFactory<tache, String>("datedenaissance"));
        amcol2.setCellValueFactory(new PropertyValueFactory<tache, String>("adressemail"));
        colquiz12.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz1"));
        colquiz22.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz2"));
        colquiz32.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz3"));
        colquizsomme2.setCellValueFactory(new PropertyValueFactory<tache, Integer>("somme"));
        String maxLineC = findMaxSommeConception();
        String[] spC= maxLineC.split(",");
        tache maxTacheC = new tache();
        maxTacheC.setId(spC[0]);
        maxTacheC.setNom(spC[1]);
        maxTacheC.setPrenom(spC[2]);
        maxTacheC.setDatedenaissance(spC[3]);
        maxTacheC.setAdressemail(spC[4]);
        maxTacheC.setQuiz1(Integer.parseInt(spC[5]));
        maxTacheC.setQuiz2(Integer.parseInt(spC[6]));
        maxTacheC.setQuiz3(Integer.parseInt(spC[7]));
        maxTacheC.setSomme(Integer.parseInt(spC[8]));
        dataC.add(maxTacheC);
        table2.setItems(dataC);
        ////////////////////////////////////////////////////webbbbbbbb
        idcol3.setCellValueFactory(new PropertyValueFactory<tache, String>("id"));
        nomcol3.setCellValueFactory(new PropertyValueFactory<tache, String>("nom"));
        prencol3.setCellValueFactory(new PropertyValueFactory<tache, String>("prenom"));
        dncol3.setCellValueFactory(new PropertyValueFactory<tache, String>("datedenaissance"));
        amcol3.setCellValueFactory(new PropertyValueFactory<tache, String>("adressemail"));
        colquiz13.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz1"));
        colquiz23.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz2"));
        colquiz33.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz3"));
        colquizsomme3.setCellValueFactory(new PropertyValueFactory<tache, Integer>("somme"));
        String maxLineW = findMaxSommeWeb();
        String[] spW= maxLineW.split(",");
        tache maxTacheW = new tache();
        maxTacheW.setId(spW[0]);
        maxTacheW.setNom(spW[1]);
        maxTacheW.setPrenom(spW[2]);
        maxTacheW.setDatedenaissance(spW[3]);
        maxTacheW.setAdressemail(spW[4]);
        maxTacheW.setQuiz1(Integer.parseInt(spW[5]));
        maxTacheW.setQuiz2(Integer.parseInt(spW[6]));
        maxTacheW.setQuiz3(Integer.parseInt(spW[7]));
        maxTacheW.setSomme(Integer.parseInt(spW[8]));
        dataW.add(maxTacheW);

        table3.setItems(dataW);
        ////////////////////////////////////////////////////////////////////////////bddddd
        idcol4.setCellValueFactory(new PropertyValueFactory<tache, String>("id"));
        nomcol4.setCellValueFactory(new PropertyValueFactory<tache, String>("nom"));
        prencol4.setCellValueFactory(new PropertyValueFactory<tache, String>("prenom"));
        dncol4.setCellValueFactory(new PropertyValueFactory<tache, String>("datedenaissance"));
        amcol4.setCellValueFactory(new PropertyValueFactory<tache, String>("adressemail"));
        colquiz14.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz1"));
        colquiz24.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz2"));
        colquiz34.setCellValueFactory(new PropertyValueFactory<tache, Integer>("quiz3"));
        colquizsomme4.setCellValueFactory(new PropertyValueFactory<tache, Integer>("somme"));

        String maxLineB = findMaxSommeBdd();
        String[] spB = maxLine.split(",");
        tache maxTacheB = new tache();
        maxTacheB.setId(spB[0]);
        maxTacheB.setNom(spB[1]);
        maxTacheB.setPrenom(spB[2]);
        maxTacheB.setDatedenaissance(spB[3]);
        maxTacheB.setAdressemail(spB[4]);
        maxTacheB.setQuiz1(Integer.parseInt(spB[5]));
        maxTacheB.setQuiz2(Integer.parseInt(spB[6]));
        maxTacheB.setQuiz3(Integer.parseInt(spB[7]));
        maxTacheB.setSomme(Integer.parseInt(spB[8]));
        dataB.add(maxTacheB);
        table4.setItems(dataB);

    }



    public void rowClicked(MouseEvent mouseEvent) {
    }
}

