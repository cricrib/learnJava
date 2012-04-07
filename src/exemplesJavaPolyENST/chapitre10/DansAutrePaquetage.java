package exemplesJava.chapitre10;

import exemplesJava.chapitre11.*;

// classe étendant DansPaquetage dans un autre paquetage
class EtendBis extends DansPaquetage {
	void faire() {
	int entier;
	DansPaquetage essai = new DansPaquetage();
	EtendBis essai1 = new EtendBis();
	SousEtendBis essai2 = new SousEtendBis();

		entier = publique;					//accessible
		entier = protege;					//accessible
		// entier = defaut;				pas accessible
		// entier = prive;					pas accessible

		entier = essai.publique;			//accessible
		// entier = essai.protege;			pas accessible
		// entier = essai.defaut;			pas accessible
		// entier = essai.prive;			accessible

		entier = essai1.protege; 			//accessible
		entier = essai2.protege; 			//accessible
	}

	protected void ecrire() {
		super.ecrire(); 					//accessible
	}
}

class SousEtendBis extends EtendBis {
	int entier;
	EtendBis essai = new EtendBis();

	SousEtendBis() {
		//entier = essai.protege;			pas accessible
	}
}

class NEtendPasBis {
	DansPaquetage essai = new DansPaquetage();
	EtendBis essaiEtendBis = new EtendBis();
	int entier;

	NEtendPasBis() {
		entier = essai.publique;			//accessible
		// entier = essai.protege;	 		pas accessible
		// entier = essai.defaut;			pas accessible
		// entier = essai.prive;		 	pas accessible

		// entier = essaiEtendBis.protege;		pas accessible

		essaiEtendBis.ecrire();			//accessible
		// essaiEtendBis.lire();			pas accessible
	}
}