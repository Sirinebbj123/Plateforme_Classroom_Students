package com.example.projetgenuis;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tache extends Apprenant {

    private StringProperty id = new SimpleStringProperty();
    private StringProperty nom = new SimpleStringProperty();
    private StringProperty prenom = new SimpleStringProperty();
    private StringProperty datedenaissance = new SimpleStringProperty();
    private StringProperty adressemail = new SimpleStringProperty();
    private Integer quiz1;
    private Integer quiz2;
    private Integer quiz3;
private Integer somme;
    private  int TOTAL_POINTS = 0;

    public tache(String id, String nom, String prn,String dn,String am,Integer q1,Integer q2,Integer q3, Integer somme,Integer tot) {
        super(id, nom, prn, dn, am);
        this.quiz1 = q1;
        this.quiz2 = q2;
        this.quiz3 = q3;

        this.TOTAL_POINTS=tot;
        this.somme=somme;
    }
    public tache(Integer q1, Integer q2, Integer q3,Integer somme){
        this.quiz1 = q1;
        this.quiz2 = q2;
        this.quiz3 = q3;

        this.somme=somme;


    }

    public tache() {
    }

    public int getTOTAL_POINTS() {
        return TOTAL_POINTS;
    }

    public void setTOTAL_POINTS(int TOTAL_POINTS) {
        this.TOTAL_POINTS = TOTAL_POINTS;
    }

    public Integer getSomme() {
        return somme;
    }

    public void setSomme(Integer somme) {
        this.somme = somme;
    }

    public Integer getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(Integer quiz1) {
        this.quiz1 = quiz1;
    }

    public Integer getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(Integer quiz2) {
        this.quiz2 = quiz2;
    }

    public Integer getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(Integer quiz3) {
        this.quiz3 = quiz3;
    }


    public int getTotalPoints() {
        return this.TOTAL_POINTS;
    }



}

