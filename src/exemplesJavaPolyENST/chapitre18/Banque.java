class Compte {
	private int capital = 0;

	// cette méthode incrémente capital de deCombien
	void credite(Banquier banquier) {
		int montant;

		System.out.println(banquier.nom + " commence son travail");
		montant = capital;
		Thread.yield();
		System.out.println(banquier.nom + " continue son travail");
		capital = montant + 1;
	}

    int getCapital() {
	return capital;
    }
}

class Banquier extends Thread {
	Compte compte;
	String nom;

	Banquier(Compte compte, String nom) {
		this.compte = compte;
		this.nom = nom;
	}

	public void run() {
		System.out.println(nom + " est embauche");
		compte.credite(this);
	}
}

class Banque {
	public static void main(String[] arg) {
		Compte compte = new Compte();
		Banquier Jean, Jacques;

		(Jean = new Banquier(compte, "Jean")).start();
		(Jacques = new Banquier(compte, "Jacques")).start();
		try {
			Jean.join();
			Jacques.join();
		}
		catch(InterruptedException e){}
		System.out.println("Votre capital est de " + compte.getCapital());
	}
}

