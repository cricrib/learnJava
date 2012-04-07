class Herbivore extends Mammifere {
	boolean ruminant;

	Herbivore(int taille, boolean ruminant) {
		super(taille) ;
		this.ruminant = ruminant;
	}

	String nourriture() {
		if (ruminant) return "Il mange des vegetaux et rumine.";
		else return "Il mange des vegetaux et ne rumine pas.";
	}

	public static void main(String[] arg) {
		Herbivore herbivore = new Herbivore(200, true);
		System.out.println(herbivore.description());
		System.out.println(herbivore.nourriture());
	}
}