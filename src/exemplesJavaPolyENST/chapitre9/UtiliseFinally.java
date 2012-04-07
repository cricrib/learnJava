class UtiliseFinally {
    static int moyenne(String[] liste) {
	int somme = 0, entier, nbEntiers = 0;
	int i = 0;
	
	for (i = 0; i < liste.length; i++) {
	    try {
		entier = Integer.parseInt(liste[i]);
		somme += entier;
		nbEntiers++;
	    }
	    finally {
		System.out.println("donnee traitee : " + liste[i]);
	    }
	}
	return somme/nbEntiers;
    }
    
    public static void main(String[] arg) {
	try {
	    System.out. println("La moyenne est "+moyenne(arg));
	}
	catch (NumberFormatException e) {
	    System.out.println("Erreur sur vos entiers");
	}
    }
}
