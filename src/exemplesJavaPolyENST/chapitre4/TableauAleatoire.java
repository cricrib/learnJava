import java.util.Random;
import java.util.Vector;

class TableauAleatoire {
	static void emplit(int[] tableau) {
		Random alea = new Random(System.currentTimeMillis());
		Vector vecteur = new Vector() ;

		for (int i = 0; i < 10; i++) vecteur.addElement
			(new Integer(Math.abs(alea.nextInt()) % 100));
	}
}
