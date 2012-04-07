import java.util.Random;

class BoiteAuxLettres {
	private boolean plein = false;
	private String lettre;

	synchronized void deposer(String lettre) {
		try {
			while (plein) wait();
		}
		catch(InterruptedException exc) {}
		this.lettre = lettre;
		System.out.println("depot de : " + lettre);
		plein = true;
		notifyAll();
	}

	synchronized String retirer(String nomConso) {
		try {
			while (!plein) wait();
		}
		catch(InterruptedException exc) {}
		System.out.println(nomConso + " lit : " + lettre);
		plein = false;
		notifyAll();
		return lettre;
	}
}

class Producteur extends Thread {
	BoiteAuxLettres boite;
	String nom;
	Random alea;

	Producteur(BoiteAuxLettres boite, String nom, Random alea) {
		this.boite = boite;
		this.nom = nom;
		this.alea = alea;
	}

	public void run() {
		for (int i = 0; i < ProdCons.TOTAL; i++) {
			try {
				sleep(Math.abs(alea.nextInt()) % 1000);
			}
			catch(InterruptedException e) {}
			boite.deposer(nom + ", lettre "+ (i + 1));
		}
	}
}

class Consommateur extends Thread {
	BoiteAuxLettres boite;
	String nom;
	Random alea;

Consommateur(BoiteAuxLettres boite, String nom, Random alea) {
		this.boite = boite;
		this.nom = nom;
		this.alea = alea;
	}

	public void run() {
		for (int i = 0; i < ProdCons.TOTAL; i++) {
			try {
				sleep(Math.abs(alea.nextInt())%1000);
			}
			catch(InterruptedException e) {}
			boite.retirer(nom);
		}
	}
}

class ProdCons {
	final static int TOTAL = 2;

	public static void main(String[] arg) {
		BoiteAuxLettres boite = new BoiteAuxLettres();
		Random alea = new Random();

		new Producteur(boite, "David", alea).start();
		new Producteur(boite, "Antoine", alea).start();
		new Consommateur(boite, "Sophie", alea).start();
		new Consommateur(boite, "Marie", alea).start();
	}
}
