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
	
	public String toString(){
		if(ruminant){
			return this.description() + " et de poids: " + poids() + ". Il est ruminant.";
		}
		return this.description() + " et de poids: " + poids() + ". Il n'est pas ruminant.";
	}
	
	public static void main(String arg[]){
		Mammifere vache; 
		vache = new Herbivore(2, true);
		System.out.println(vache.toString());
	}
}
