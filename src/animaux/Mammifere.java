package animaux;

public class Mammifere {
	int taille;
	int age;
	Mammifere(){
		System.out.println("hola ");
	}
	
	Mammifere(int taille){
		this(); //affichera hola
		this.taille = taille;
	}
	
	String description(){
		return "Animal a sang chaud de taille: " + this.taille; 
	}
}
