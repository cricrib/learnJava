package pile;

import java.util.LinkedList;

public class Pile2 {
	private LinkedList<Integer> liste = new LinkedList<Integer>();
	
	void empiler(int n){
		this.liste.add(n);
	}
	
	int depiler() throws ExceptionPileVide{
		if(this.liste.isEmpty()){
			throw new ExceptionPileVide();
		}
		int cle = this.liste.get(this.liste.size() - 1);
		this.liste.remove(this.liste.size() - 1);
		return cle;
	}
	
	//inutile car utiliser isEmpty
	boolean estVide(){
		int taille = this.liste.size();
		return taille == 0;
	}
	
	LinkedList<Integer> getListe(){
		return this.liste;
	}

}
