package statique;

public class Statique {
	static int ajouter(int k, int p){
		k += p;
		return k;
	}
	static void changer(int i, int[] tab){
		i = i + 5; // pige!!!!
		tab[0] = 8;
	}
	
	static int changerPrimitif(int j){
		return j + 5;
	}
}
