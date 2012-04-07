import java.util.Random;
import java.util.Vector;

class DesClasses {
    public static void main(String[] arg) {
	Random alea = new Random(System.currentTimeMillis());
	Vector vecteur = new Vector();
	//Vector<Integer[]> vecteur = new Vector<Integer[]>();
	Integer[] tableau;
	
	for (int i = 0; i < 3; i++) {
	    tableau = new Integer[4];
	    for (int j = 0; j < tableau.length; j++) 
		{
		    tableau[j] = new Integer(Math.abs(alea.nextInt()) % 21);
		    System.out.print(tableau[j] + "\t");
		}
	    vecteur.add(tableau);
	    System.out.println();
	}
	int valCherchee = Integer.parseInt(arg[0]);
	int valeur;
	boolean existe = false;
	recherche:
	for (int i = 0; i < vecteur.size(); i++) {
	    tableau = (Integer[])vecteur.elementAt(i);
	    for (int j = 0; j < tableau.length; j++) {
		valeur = tableau[j].intValue();
		if (valeur == valCherchee) {
		    existe = true;
		    break recherche;
		}
	    }
	}
	if (existe) System.out.println(valCherchee + " existe");
	else System.out.println(valCherchee + " n'existe pas");
    }
}

/*  
javac DesClasses.java  

Note: DesClasses.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.


javac -Xlint:unchecked DesClasses.java  

DesClasses.java:18: warning: [unchecked] unchecked call to add(E) as a member of the raw type java.util.Vector
            vecteur.add(tableau);
                       ^
1 warning
*/
