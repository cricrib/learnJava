package exemplesJava.chapitre11;

class NEtendPas { //meme paquetage que EssaiPaquetage {
	EssaiPaquetage essai = new EssaiPaquetage();
	int entier;

	NEtendPas() {
		entier = essai.publique;		//visible
		entier = essai.protege;		//visible
		entier = essai.defaut;		//visible
		//entier = essai.prive;		pas accessible

	 essai.ecrire();			//visible
	}
}

//classe etendant EssaiPaquetage dans le meme paquetage
class Etend extends EssaiPaquetage {
	int entier;

	Etend() {
		entier = publique;				//h�rit�
		entier = protege;				//h�rit�
		entier = defaut;				//h�rit�
 	 //entier = prive;					pas herit�
		ecrire();							//h�rit�
	}
}
