import java.util.Random;
class Collecteur extends Thread {
	StringBuilder texte = new StringBuilder();
	boolean travailAFaire = false;
	String mot;

	Collecteur() {
		setDaemon(true);
	}

	public synchronized void run() {
		try {
			while(true) {
				while(!travailAFaire) wait();
				texte.append(mot);
				System.out.println(texte);
				travailAFaire = false;
				notifyAll();
			}
		}
		catch(InterruptedException e) {}
	}
}

class ProducteurMots extends Thread {
	Collecteur collecteur;
	String mot;
	Random alea;

	ProducteurMots(Collecteur collecteur, String mot, Random alea) {
		this.collecteur = collecteur;
		this.mot = mot;
		this.alea = alea;
	}

	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				sleep(Math.abs(alea.nextInt())%10);
				synchronized(collecteur) {
					while (collecteur.travailAFaire) collecteur.wait();
					collecteur.mot = this.mot;
					collecteur.travailAFaire = true;
					collecteur.notifyAll();
				}
			}

		// Ce qui suit évite que le programme ne se termine 
		// avant que le démon n'ait écrit sa dernière ligne
			synchronized(collecteur) {
				while(collecteur.travailAFaire) collecteur.wait();
			}
		}
		catch(InterruptedException e) {}
	}
}

class Assemble {
	public static void main(String[] arg) {
		Collecteur collecteur = new Collecteur();
		Random alea = new Random();

		collecteur.start();
		new ProducteurMots(collecteur, "soleil ", alea).start();
		new ProducteurMots(collecteur, "lune ", alea).start();
	}
}
