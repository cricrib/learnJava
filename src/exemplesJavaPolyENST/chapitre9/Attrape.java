class Attrape {
    static int moyenne(String[] liste) {
	int somme = 0, entier, nbEntiers = 0;
	
	for (int i = 0; i < liste.length; i++) {
	    try {
		entier = Integer.parseInt(liste[i]);
		somme += entier;
		nbEntiers++;
	    }
	    catch (NumberFormatException e) {
		System.out.println("La "+ (i + 1) +
		       " eme chaine n'est pas entiere");
	    }
	}
		return somme/nbEntiers;
    }
    
    public static void main(String[] arg) {
	System.out. println("La moyenne est " + moyenne(arg));
    }
}
