class SaisieClavierBis {
    public static void main (String[] arg)  {
	java.util.Scanner entree = new java.util.Scanner(System.in);
	
	System.out.println("Donnez votre prénom et votre nom");
	String prenom = entree.next();
	String nom = entree.next();
	System.out.println("Donnez votre âge");
	int age = entree.nextInt();
	entree.nextLine();
	System.out.println("Ecrire votre phrase");
	String phrase = entree.nextLine();
	System.out.println(prenom + " " + nom + ", " + age + " ans, dit : " + phrase);
    }
}

/* Donnez votre prénom et votre nom
Marie Azulay
Donnez votre âge
22
Ecrire votre phrase
Coucou cher lecteur
Marie Azulay, 22 ans, dit : Coucou cher lecteur
*/
