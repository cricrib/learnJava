package banque; 

public class CompteB {
  private String proprietaire;
  private int numero;
  private int montant;
  public CompteB(String proprietaire, int numero, int montantInitial) {
	  this.proprietaire = proprietaire;
	  this.numero = numero;
	  this.montant = montantInitial;
  }
  public void modifier(int somme) {
	  if (this.montant + somme >= 0)
		  this.montant = this.montant + somme;
  }
  
  public String getProprietaire() {
	  return this.proprietaire;
  }
  
  public int getNumero() {
	  return this.numero;
  }
  
  public int getMontant(){
	  return this.montant;
  }
  
  public String toString() {
	  return "Compte numero " + this.numero + ": proprietaire " + 
              this.proprietaire + ", montant " + this.montant;
  }
}
