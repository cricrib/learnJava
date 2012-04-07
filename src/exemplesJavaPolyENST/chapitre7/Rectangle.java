class Rectangle extends Forme {
    private int longueur, largeur;;
    
    Rectangle(int longueur, int largeur) {
	this.longueur = longueur;
	this.largeur = largeur;
    }
    
    double perimetre() {
	return 2*(longueur + largeur);
    }
    
    double surface() {
	return longueur*largeur;
    }
    
    public String toString() {
	return ("Le rectangle de longueur " + longueur +
		" et de largeur " + largeur);
    }
}
