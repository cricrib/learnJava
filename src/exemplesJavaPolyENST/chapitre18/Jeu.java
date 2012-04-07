class Joueur extends Thread {
	java.util.Random alea; 
	int resultat;
	String nom;
	boolean tirageFait = false;
	boolean fini = false;
	Joueur adversaire;

	Joueur(java.util.Random alea, String nom) {
		this.alea = alea;
		this.nom = nom;
	}

	public void run() {
		try {
			sleep(Math.abs(alea.nextInt()) % 1000);
			resultat = Math.abs(alea.nextInt()) % 10000;
			tirageFait = true;
			synchronized(this) {
				notify();
			}
			synchronized(adversaire) {
				while (!adversaire.tirageFait) adversaire.wait();
			}
			String phrase = (resultat >= adversaire.resultat ?
					 ", j'ai gagné" : ", j'ai perdu");  
			System.out.println(nom + " : " + resultat + phrase);
			sleep(Math.abs(alea.nextInt()) % 1000);
			fini = true;
			synchronized(adversaire) {
				while (!adversaire.fini) adversaire.wait();
			}
		}
		catch(InterruptedException exc) {}
		System.out.println(nom + " vous dit au revoir");
	}
}

class Jeu {
	public static void main(String[] arg) {
		java.util.Random alea = new java.util.Random();
		Joueur David = new Joueur(alea, "David");
		Joueur Antoine = new Joueur(alea, "Antoine");

		Antoine.adversaire = David;
		David.adversaire = Antoine;
		David.start();
		Antoine.start();
	}
}

