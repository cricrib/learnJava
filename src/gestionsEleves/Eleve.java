package gestionsEleves;

import java.util.*;

public class Eleve {
  private String nom;
  private ArrayList<Integer> listeNotes = new ArrayList<Integer>();
  private double moyenne = 0.0;
  
  Eleve(String nom) {
	  this.nom = nom; 
  }
  
  public double getMoyenne() {
	  return this.moyenne;
  }
  
  public String getNom() {
	  return this.nom;
  }
  
  public ArrayList<Integer> getListeNotes() {
	  return this.listeNotes;
  }

  public void ajouterNote(int note) {
	  if(note < 0 || note > 20) {
		  note = 0;
	  }
	  this.listeNotes.add(note);
	  int nb = this.listeNotes.size();
	  //calculer la moyenne
	  this.moyenne = ((nb - 1) * this.moyenne + note) / nb;
	 //ATTENTION quand nombres sont entiers java les arrondis 
	 //DONC (4 - 1) / 4 = 0 ! 
  }
  
  public String toString() {
	  return this.nom + " a une moyenne de " + this.moyenne;
  }
}
