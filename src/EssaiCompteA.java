import banque.CompteB;

class CompteA {
    // Constructeur
    CompteA() {
    }

    //Un attribut
    int montant;
    
    // Une méthode qui credite le compte 
    void modifier(int somme) {
	this.montant = this.montant + somme;
    }
}


public class EssaiCompteA {
	public static void main(String[] arg) {
		CompteA monCompte;
		CompteB monCompte2;
		CompteB autreCompte;
        monCompte = new CompteA();
        monCompte2  = new CompteB("Chris", 1234567, 220);
        //autreCompte = unCompte; a conduit à ce que les deux variables 
        //monCompte2 et autreCompte référencent le même compte.
        autreCompte = monCompte2;
		monCompte.montant = 10;
		monCompte.modifier(150);
		monCompte2.modifier(30);
		System.out.println("Montant du compte A: " + monCompte.montant);
		System.out.println("Montant du compte B: " + monCompte2.getMontant());
		System.out.println("Montant de l'autre Compte: " + autreCompte.getMontant());
		System.out.println(autreCompte.toString());
	    }
}

