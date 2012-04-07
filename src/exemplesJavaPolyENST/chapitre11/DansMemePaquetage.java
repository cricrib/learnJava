package exemplesJava.chapitre11;

class NEtendPas { //meme paquetage que DansPaquetage {
	DansPaquetage essai = new DansPaquetage();
	int entier;

	NEtendPas() {
		entier = essai.publique;		//visible
		entier = essai.protege;		//visible
		entier = essai.defaut;		//visible
		//entier = essai.prive;		pas accessible

	 essai.ecrire();			//visible
	}
}

//classe etendant DansPaquetage dans le meme paquetage
class Etend extends DansPaquetage {
	int entier;

	Etend() {
		entier = publique;				//hérité
		entier = protege;				//hérité
		entier = defaut;				//hérité
 	 //entier = prive;					pas herité
		ecrire();							//hérité
	}
}
