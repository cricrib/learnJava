class Forme {
    double perimetre() {
	return 0;
    }
    
    double surface(){
	return 0;
    }
    
    void decritEtalement() {
	double lePerimetre = perimetre();
	
	if (surface() >= lePerimetre*lePerimetre/16)
	    System.out.println(this + " s'etale plus qu'un carre");
	else System.out.println(this + " s'etale moins qu'un carre");
    }
}
