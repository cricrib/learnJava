class SaisieClavierBis {
    public static void main (String[] arg)  {
	java.util.Scanner entree = new java.util.Scanner(System.in);
	
	System.out.println("Donnez votre pr�nom et votre nom");
	String prenom = entree.next();
	String nom = entree.next();
	System.out.println("Donnez votre �ge");
	int age = entree.nextInt();
	entree.nextLine();
	System.out.println("Ecrire votre phrase");
	String phrase = entree.nextLine();
	System.out.println(prenom + " " + nom + ", " + age + " ans, dit : " + phrase);
    }
}

/* Donnez votre pr�nom et votre nom
Marie Azulay
Donnez votre �ge
22
Ecrire votre phrase
Coucou cher lecteur
Marie Azulay, 22 ans, dit : Coucou cher lecteur
*/
