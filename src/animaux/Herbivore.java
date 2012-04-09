package animaux;

public class Herbivore extends Mammifere {
	boolean ruminant;
	
	Herbivore(int taille, boolean ruminant){
		super(taille);
		this.ruminant = ruminant;
	}
	
	int poids(){
		int poids = 2 * this.taille;
		return poids;
	}
	
	//Redéfinir une méthode au sein d'une meme classe avec differents param est ok
	String poids(int poids){
		return Integer.toString(this.taille * 2); 
	}
	
	//Redefinir une methode heritee doit avoir meme parametres! 
	String description(){
		return "hello le renomage";
	}
	
	public String toString(){ //must be public because cannot change visibility of unherited method
		if(ruminant){
			return this.description() + " et de poids: " + poids() + ". Il est ruminant.";
		}
		return this.description() + " et de poids: " + poids() + ". Il n'est pas ruminant.";
	}
}
