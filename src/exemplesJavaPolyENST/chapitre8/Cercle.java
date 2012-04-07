class Cercle {
	int rayon;

	Cercle(int rayon) {
		this.rayon = rayon;
	}

	double circonference() {
		return 2 * Math.PI * rayon;
	}
}
