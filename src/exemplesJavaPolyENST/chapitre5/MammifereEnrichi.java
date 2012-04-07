class MammifereEnrichi extends Mammifere {
	boolean agressif;

	MammifereEnrichi(int taille, boolean agressif) {
		super(taille);
		this.agressif = agressif;
	}

	boolean bonCompagnon() {
		if ((!agressif) && (taille < 250))return true;
		else return false;
	}

	public static void main(String[] arg) {
		MammifereEnrichi animal = new MammifereEnrichi(50, false);
		System.out.println(animal.description());
		if (animal.bonCompagnon())
System.out.println("Vous pouvez l'adopter.");
		else System.out.println("Vous pourriez avoir des problèmes.");
	}
}
