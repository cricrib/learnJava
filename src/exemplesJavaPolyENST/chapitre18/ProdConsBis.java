import java.util.Random;

class BoiteBis {
	boolean plein = false;
	String lettre;

	void deposer(String lettre) {
		this.lettre = lettre;
		System.out.println("depot de : " + lettre);
		plein = true;
	}

	String retirer(String nomConso) {
		plein = false;
		System.out.println(nomConso + " lit : " + lettre);
		return lettre;
	}
}

class ProducteurBis extends Thread {
	BoiteBis boite;
	String nom;
	Random alea;

	ProducteurBis(BoiteBis boite, String nom, Random alea) {
		this.boite = boite;
		this.nom = nom;
		this.alea = alea;
	}

	public void run() {
		try {
			for (int i = 0; i < ProdCons.TOTAL;i++) {
				sleep(Math.abs(alea.nextInt())%1000);
				synchronized(boite) {
					while(boite.plein) {
						boite.wait();
					}
					boite.deposer(nom + ", lettre " + (i + 1));
					boite.notifyAll();
				}
			}
		}
		catch(InterruptedException exc) {
			System.out.println("Interruption");
			System.exit(1);
		}
	}
}

class ConsommateurBis extends Thread {
	BoiteBis boite;
	String nom;
	String lettre;
	Random alea;

	ConsommateurBis(BoiteBis boite, String nom, Random alea) {
		this.boite = boite;
		this.nom = nom;
		this.alea = alea;
	}

	public void run() {
		try {
			for (int i = 0; i < ProdCons.TOTAL;i++) {
				sleep(Math.abs(alea.nextInt())%1000);
				synchronized(boite) {
					while(!boite.plein) {
						boite.wait();
					}
					lettre = boite.retirer(nom);
					boite.notifyAll();
				}
			}
		}
		catch(InterruptedException exc) {
			System.out.println("interruption");
			System.exit(1);
		}
	}
}

class ProdConsBis {
	final static int TOTAL = 2;

	public static void main(String[] arg) {
		BoiteBis boite = new BoiteBis();
		Random alea = new Random(System.currentTimeMillis());

		(new ProducteurBis(boite, "David", alea)).start();
		(new ProducteurBis(boite, "Antoine", alea)).start();
		(new ConsommateurBis(boite, "Sophie", alea)).start();
		(new ConsommateurBis(boite, "Marie", alea)).start();
	}
}