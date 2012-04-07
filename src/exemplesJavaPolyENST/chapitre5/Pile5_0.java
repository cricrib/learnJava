import java.util.Stack;

class Pile {
    static Stack<Number> pile = new Stack<Number>();
    
    static void toutRangerDansPile(String[] liste) {
	for (int i = 0; i < liste.length; i++) {
	    try {
		pile.push(new Integer(liste[i]));
	    }
	    catch(NumberFormatException e1) {
		try {
		    pile.push(new Double(liste[i]));
				}
		catch(NumberFormatException e2) {
		    System.out.println("L'argument " + liste[i] + " ne represente ni un double ni un int");
		}
	    }
	}
    }
    
    static int viderPileSommerEntiers() {
	int sommeEntiers = 0;
	while(!pile.empty()) {
	    Object objet;
	    
	    objet = pile.pop();
	    System.out.println("Instance de " + 
			       objet.getClass() + " qui vaut " + objet);
	    if (objet instanceof Integer)
		sommeEntiers += (Integer)objet;
	}
	return sommeEntiers;
    }
    
    public static void main(String[] arg) {
	toutRangerDansPile(arg);
	int total = viderPileSommerEntiers();
	System.out.println("La somme des entiers vaut " + total);
    }
}

