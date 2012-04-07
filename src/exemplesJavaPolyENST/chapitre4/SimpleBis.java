class SimpleBis {
	int x;
	
	SimpleBis(int valeur) {
		this.x = valeur;
	}

	void doubler() {
		this.x = 2 * this.x;
	}

	void transformer() {
		this.doubler();
		this.x += 1;
	}
}
