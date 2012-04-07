package exemplesJava.chapitre10;

import exemplesJava.chapitre11.EssaiPaquetage;

class NEtendPasBis {
	EssaiPaquetage essai = new EssaiPaquetage();
	EtendBis essaiEtendBis = new EtendBis();
	int entier;

	NEtendPasBis() {
		entier = essai.publique;			//visible
		// entier = essai.protege;	 		pas accessible
		// entier = essai.defaut;			pas accessible
		// entier = essai.prive;		 	pas accessible

		// entier = essaiEtendBis.protege;	pas accessible

		essaiEtendBis.ecrire();				//visible
		// essaiEtendBis.dire();			pas accessible
	}
}
// classe etendant EssaiPack dans un autre paquetage
class EtendBis extends EssaiPaquetage {
	void faire() {
		int entier;
		EssaiPaquetage essai = new EssaiPaquetage();
		SousEtendBis essai2 = new SousEtendBis();
		EtendBis essai1 = new EtendBis();

		entier = essai1.protege; 			//visible
		entier = essai2.protege; 			//visible

		entier = publique;				//visible
		entier = protege;				//visible
		// entier = defaut;				pas herité
		// entier = prive;				pas herité

		entier = essai.publique;			//visible
		// entier = essai.protege;			pas accessible
		// entier = essai.defaut;			pas accessible
		// entier = essai.prive;			accessible

	}

	protected void ecrire() {
		super.ecrire();
	}
}

class SousEtendBis extends EtendBis {
	int entier;
	EtendBis essai = new EtendBis();

	SousEtendBis() {
		//entier = essai.protege;		pas accessible
	}
}
