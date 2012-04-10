package pile;

import java.util.ArrayList;

public class PileListeChainee {
	Maillon debut;
	
	void empiler(int cle){
		Maillon maillon = new Maillon(cle, debut);
		this.debut = maillon;
	}
	
	int depiler() throws ExceptionPileVide{
		if(estVide()) throw new ExceptionPileVide();
		int cle = debut.donnee;
		this.debut = debut.suivant;
		return cle;
	}
	
	boolean estVide(){
		return debut == null;
	}
	
	ArrayList<Integer> getListe(){
		ArrayList<Integer> liste = new ArrayList<Integer>();
		Maillon maillon = new Maillon(debut.donnee, debut.suivant);
		while(maillon !=null){ //Et pas maillon.suivant !=null sinon un élément de moins dans le liste
			liste.add(maillon.donnee);
			maillon = maillon.suivant;
		}
		return liste;
	}
}
