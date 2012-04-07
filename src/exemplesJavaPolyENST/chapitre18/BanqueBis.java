class CompteSynchro {
	private int capital = 0;

	synchronized void credite(BanquierBis banquier) {
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

class BanquierBis extends Thread {
	CompteSynchro compte;
	String nom;
	BanquierBis(CompteSynchro compte, String nom) {
		this.compte = compte;
		this.nom = nom;
	}

	public void run() {
		System.out.println(nom + " est embauche");
		compte.credite(this);
	}
}

class BanqueBis {
	public static void main(String[] arg) {
		CompteSynchro compte = new CompteSynchro();
		BanquierBis Jean, Jacques;

		(Jean = new BanquierBis(compte, "Jean")).start();
		(Jacques = new BanquierBis(compte, "Jacques")).start();
		try {
			Jean.join();
			Jacques.join();
		}
		catch(InterruptedException e){}
		System.out.println("Votre capital est de " + compte.getCapital());
	}
}

