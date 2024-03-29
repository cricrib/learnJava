package pile;

import java.util.ArrayList;

public class Pile1 {
	private ArrayList<Integer> liste = new ArrayList<Integer>();
	
	void empiler(int n){
		this.liste.add(n);
	}
	
	int depiler() throws ExceptionPileVide{
		if(estVide()){
			throw new ExceptionPileVide();
		}
		int cle = this.liste.get(this.liste.size() - 1);
		this.liste.remove(this.liste.size() - 1);
		return cle;
	}
	
	boolean estVide(){
		int taille = this.liste.size();
		return taille == 0;
	}
	
	ArrayList<Integer> getListe(){
		return this.liste;
	}
}
