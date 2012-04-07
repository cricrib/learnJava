class Lance {
    static int moyenne(String[] liste) throws ExceptionRien {
	int somme = 0, entier, nbEntiers = 0;
	int i;
	
	for (i = 0; i < liste.length; i++) {
	    try {
		entier = Integer.parseInt(liste[i]);
		somme += entier;
		nbEntiers++;
	    }
	    catch (NumberFormatException e) {
		System.out.println("La "+(i+1) +
				   " eme chaine n'est pas entiere");
	    }
	}
	if (nbEntiers == 0) throw new ExceptionRien(liste.length);
	return somme/nbEntiers;
    }
    
    public static void main(String[] arg) {
	try {
	    System.out.println("La moyenne est " + moyenne(arg));
	}
	catch (ExceptionRien e) {
	    System.out.println(e);
	}
    }
}
