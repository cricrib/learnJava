import java.util.Random;
import java.util.Vector;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.abs;

class DesClasses5_0 {
    public static void main(String[] arg) {
	Random alea = new Random();
	Vector<Integer[]> vecteur = new Vector<Integer[]>();

	Integer[] tableau;
	
	for (int i = 0; i < 3; i++) {
	    tableau = new Integer[4];
	    for (int j = 0; j < tableau.length; j++)
		{
		    tableau[j] = abs(alea.nextInt()) % 21;
		    out.print(tableau[j] + "\t");
		}
	    vecteur.add(tableau);
	    out.println();
	}
	Scanner entree = new Scanner(in);
	int valCherchee = entree.nextInt();
	boolean existe = false;
	recherche:
	for (Integer[] table : vecteur) {
	    for (int valeur : table) {
		if (valeur == valCherchee) {
		    existe = true;
		    break recherche;
		}
	    }
	}
	if (existe) out.println(valCherchee + " existe");
	else out.println(valCherchee + " n'existe pas");
    }
}
/*
8       4       5       12
4       20      20      12
0       10      7       8
12 existe
*/
