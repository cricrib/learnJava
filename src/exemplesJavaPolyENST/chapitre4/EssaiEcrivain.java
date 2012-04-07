class Ecrivain {
	static int nbEcrivains;
	String nom;

	Ecrivain (String leNom) {
		nom = leNom;
		nbEcrivains++;
	}

	static void donnerQuantite() {
		System.out.println("Nous avons construit " +
 			nbEcrivains + " ecrivain(s)");
	}

	void bienvenue() {
		System.out.println(nom + " vous salue");
	}
}

class EssaiEcrivain {
	public static void main(String[] arg) {
		Ecrivain[] ecrivains = new Ecrivain[5];

		Ecrivain.donneQuantite();
		ecrivains[0] = new Ecrivain("Emile");
		ecrivains[1] = new Ecrivain("Boris");
		Ecrivain.donnerQuantite();
		ecrivains[0].nom += " Zola";
		ecrivains[1].nom += " Vian";
		for (int i = 0; i < Ecrivain.nbEcrivains ; i++)
			System.out.println(ecrivains[i].nom);
		ecrivains[0].bienvenue();
	}
}
