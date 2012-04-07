class Simple {
	int x;
	
	Simple(int valeur) {
		x = valeur;
	}
	
	void doubler() {
		x = 2 * x;
	}

	void transformer() {
		doubler();
		x += 1;
	}
}
