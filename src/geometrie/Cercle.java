package geometrie;

class Cercle {
	int rayon;
	Cercle(int rayon){
		this.rayon = rayon;
	}

	double circonference(){
		double circ = Math.PI * this.rayon * 2;
		return circ;
	}
}

