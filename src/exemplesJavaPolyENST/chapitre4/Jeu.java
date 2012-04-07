class Joueur {
    String nom;
    int score = 0;
    double force;

       Joueur (String leNom) {
	   nom = leNom;
	   force = 1.0 + Jeu.alea.nextDouble();
	System.out.println("Force : " + force);
	}

    double lancer() {
	return (Jeu.entierAleatoire()) * force;
    }
}

class Jeu {

    static java.util.Random alea = new java.util.Random();
    
    static int entierAleatoire() {
	return Math.abs(alea.nextInt());
    }

    Joueur joueur1 = new Joueur("Frederic");
    Joueur joueur2 = new Joueur("Alain");;

    Jeu() {
	Joueur gagnant = jouerPartie();
	if (gagnant != null)
	    System.out.println("Le gagnant est " + gagnant.nom);
	else
	    System.out.println("Egalite");
	System.out.println("Forces : " + joueur1.force + " " + joueur2.force);
	System.out.println("Scorese : " + joueur1.score + " " + joueur2.score);
    }
    
    Joueur jouerPartie() {
	for (int i = 0; i < 10; i++) {
	    if (joueur1.lancer() > joueur2.lancer()) {
		joueur1.score++;
		joueur2.force *= 1.1;
		joueur1.force /= 1.1;
	    }
	    else {
		joueur2.score++;
		joueur1.force *= 1.1;
		joueur2.force /= 1.1;
	    }
	}
	if (joueur1.score > joueur2.score) return joueur1;
	else if (joueur2.score > joueur1.score) return joueur2;
	else return null;
    }
    
    public static void main(String[] arg) {
	new Jeu();
    } 
}
