abstract class Forme {
    abstract double perimetre();	//methode abstraite
    abstract double surface();	//methode abstraite
    
    void decritEtalement() {
	double lePerimetre = perimetre();
	
	if (surface() >= lePerimetre*lePerimetre/16)
	    System.out.println(this +
			       " s'etale plus qu'un carre");
	else System.out.println(this + " s'etale moins qu'un carre");
    }
}
