class Mammifere {
	int taille;

	Mammifere(int taille) {
		this.taille = taille;
	}

	String description() {
		return "Animal � sang chaud mesurant " + taille + " cm.";
	}
}