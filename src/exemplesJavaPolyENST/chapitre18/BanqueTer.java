class BanquierTer extends Banquier {
	BanquierTer(Compte compte, String nom) {
		super(compte, nom);
	}

	public void run() {
		System.out.println(nom + " est embauche");
		synchronized(compte) {
			compte.credite(this);
		}
	}
}

class BanqueTer {
	public static void main(String[] arg) {
		Compte compte = new Compte();
		BanquierTer Jean, Jacques;

		(Jean = new BanquierTer(compte, "Jean")).start();
		(Jacques = new BanquierTer(compte, "Jacques")).start();
		try {
			Jean.join();
			Jacques.join();
		}
		catch(InterruptedException e){}
		System.out.println("Votre capital est de " + compte.getCapital());
	}
}

