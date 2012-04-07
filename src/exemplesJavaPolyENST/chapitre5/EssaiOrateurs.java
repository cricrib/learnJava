class Orateur {
	String action() {
		return "s'exprime";
	}
}

class Grenouille extends Orateur {
	String action() {
		return "coasse";
	}
}

class Fourmi extends Orateur {
	String action() {
		return "croonde";
	}
}

class EssaiOrateurs {
	public static void main(String[] arg) {
		Orateur orateur;

		orateur = new Orateur();
		System.out.println("Orateur " + orateur.action());
		orateur = new Grenouille();
		System.out.println("Grenouille "+ orateur.action());
		orateur = new Fourmi();
		System.out.println("Fourmi " + orateur.action());
	}
}
