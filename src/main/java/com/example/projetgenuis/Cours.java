package com.example.projetgenuis;
import java.util.ArrayList;
import java.util.LinkedList;

public class Cours {
    private String nomCour;
 // private final int nbTotalpts=100;
    private LinkedList<tache> taches;
    private LinkedList<Apprenant> apprenants;

    public Cours( String nom,LinkedList<tache>taches) {
        this.nomCour = nom;
    this.taches = new LinkedList<>();

        this.apprenants = new LinkedList<>();
    }

    public String getNomCour() {
        return nomCour;
    }

    public void setNomCour(String nomCour) {
        this.nomCour = nomCour;
    }


    public LinkedList<tache> getTaches() {
        return taches;
    }

    public void setTaches(LinkedList<tache> taches) {
        this.taches = taches;
    }

    public LinkedList<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(LinkedList<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }

    public void addTache(tache tache) {
        this.taches.add(tache);
    }

    public void removeTache(tache tache) {
        this.taches.remove(tache);
    }

    public void addApprenant(Apprenant apprenant) {
        this.apprenants.add(apprenant);
    }

    public void removeApprenant(Apprenant apprenant) {
        this.apprenants.remove(apprenant);
    }

}