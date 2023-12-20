package com.example.projetgenuis;

import java.util.LinkedList;

public interface Iapprenant {
 public void ajouter(Apprenant apprenant);
 public  void supprimer(Apprenant apprenant);
 public void rechercher(Apprenant apprenant);
 public void modifier(Apprenant apprenant);
 public LinkedList<Apprenant> getAll();

}
