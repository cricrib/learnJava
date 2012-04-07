class Mammifere {
	int taille;

	Mammifere(int taille) {
		this.taille = taille;
	}

	String description() {
		return "Animal à sang chaud mesurant " + taille + " cm.";
	}
}