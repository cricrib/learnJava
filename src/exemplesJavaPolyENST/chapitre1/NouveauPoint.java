class NouveauPoint {
	// Les attributs
	int x, y;
	
	// constructeur de la classe
	NouveauPoint(int abs, int ord) {
		x = abs;
		y = ord;
	}
	
	//Méthode qui permet de translater le point
	void translate(int h, int k) {
		x += h;
		y += k;
	}
}
