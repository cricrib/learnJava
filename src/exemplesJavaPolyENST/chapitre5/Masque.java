class Haut {
	int i = 1;
}

class Bas extends Haut {
	int i = 2;
}

class Masque {
	public static void main(String[] arg) {
		Bas bas = new Bas();
		Haut haut = bas;

		System.out.println("bas.i vaut " + bas.i);
		System.out.println("haut.i vaut " + haut.i);
		System.out.println("((Haut)bas).i vaut " + ((Haut)bas).i);
		System.out.println("((Bas)haut).i vaut " + ((Bas)haut).i);

		((Haut)bas).i = 100;
		System.out.println("\nbas.i vaut " + bas.i);
		System.out.println("haut.i vaut " + haut.i);
	}
}
