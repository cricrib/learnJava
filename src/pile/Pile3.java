package pile;

import java.util.ArrayList;

public class Pile3 {
	private int[] tableau = new int[5];
	private int hauteur = 0;
	
	
	void empiler(int cle) throws ExceptionPilePleine{
		if(hauteur < this.tableau.length){
			hauteur++;
			this.tableau[hauteur - 1] = cle;
		}
		else{
			throw new ExceptionPilePleine();					
		}
	}
	
	int depiler() throws ExceptionPileVide{
		if(hauteur == 0){
			throw new ExceptionPileVide();//pas de 'try' donc la mŽthode se termine aprs le if. Pas besoin de if-else.  
		}
		int cle = this.tableau[hauteur - 1];
		hauteur--;
		return cle;
	}
	
	ArrayList<Integer> getListe(){
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(int i = 0; i < hauteur; i++ ){
			liste.add(tableau[i]);
		}
		return liste;
	}

}
