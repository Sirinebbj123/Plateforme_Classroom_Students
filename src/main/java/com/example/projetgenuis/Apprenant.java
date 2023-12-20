package com.example.projetgenuis;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Apprenant   {
  private StringProperty id=new SimpleStringProperty();
    private StringProperty   nom=new SimpleStringProperty();
    private  StringProperty  prenom=new SimpleStringProperty();
    private StringProperty  datedenaissance=new SimpleStringProperty();
    private  StringProperty  adressemail=new SimpleStringProperty();

 //   private StringProperty cours=new SimpleStringProperty();

   public  Apprenant(String id, String nom, String prn, String dn, String am){
     this.id=new SimpleStringProperty(id);
        this.nom=new SimpleStringProperty(nom);
        this.prenom=new SimpleStringProperty(prn);
        this.datedenaissance=new SimpleStringProperty(dn);
        this.adressemail=new SimpleStringProperty(am);
   //     this.cours=new SimpleStringProperty(cours);
    }

    public Apprenant() {

    }





  /*  public static void add(Apprenant st) {
    }*/

    public String getId() {
        return id.get();
    }

    public String setId(String id) {
        this.id.set(id);
        return id;
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getDatedenaissance() {
        return datedenaissance.get();
    }

    public String getAdressemail() {

        return adressemail.get();
    }

    public void setNom(String nom) {
this.nom.set(nom);

    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance.set(datedenaissance);
    }

    public void setAdressemail(String adressemail) {
        this.adressemail.set(adressemail);
    }
}
