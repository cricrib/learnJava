package statique;

/**
 * Les types primitifs et les types par r�f�rence. 
 * 
 * @author chris
 *
 */

public class TestStatique {
	public static void main(String arg[]){
		int k = Statique.ajouter(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));
		int i = 2;
		int[] tab = {0};
		Statique.changer(i, tab);//uniquement les types par r�f�rence auront leur valeur chang�e
		int p = 2; 
		p = Statique.changerPrimitif(p);
		System.out.println("k="+ k + "  i = "+ i + "  tab[0] = " + tab[0] + "  p = " + p);
	}

}
