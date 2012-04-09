package animaux;

public class Mammifere {
	int taille;
	int age;
	Mammifere(){
		System.out.println("hola ");
	}
	//chainage de constructeurs
	Mammifere(int taille){
		this(); //affichera hola
		this.taille = taille;
	}
	
	String description(){
		return "Animal a sang chaud de taille: " + this.taille; 
	}
	final String laTaille(){//cette methode ne pourra être redéfinie dans Herbivore
		return " Cette méthode ne peut pas être redéfinie";
	}
}
