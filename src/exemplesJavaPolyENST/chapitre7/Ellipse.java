class Ellipse extends Forme {
    private int grandAxe, petitAxe;
    
    Ellipse(int grandAxe, int petitAxe) {
	this.grandAxe = grandAxe;
	this.petitAxe = petitAxe;
    }
    
    double perimetre() {			// calcul approché
	double resultat = 0;
	double pcarre = petitAxe * petitAxe;
	double gcarre = grandAxe * grandAxe;
	double sinus, cosinus;
	
	for (int i = 0; i < 1000; i++) {
	    sinus = Math.sin(i*Math.PI/2000);
	    cosinus = Math.cos(i*Math.PI/2000);
	    resultat += 
		Math.sqrt(pcarre*sinus*sinus+gcarre*cosinus*cosinus);
	}
	resultat *= 4*Math.PI/2000;
	return resultat;
    }
    
    double surface() {
	return Math.PI*petitAxe*grandAxe;
    }
    
    public String toString() {
	return ("L'ellipse de grand axe " + grandAxe + 
		", de petit axe " + petitAxe);
    }
}
