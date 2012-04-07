class Concatenation {
	public static void main(String[] argv) {
		String chaine = "le soleil";
		byte p = 3;
		double x = 51.2;

		System.out.println(chaine+p);
		System.out.println("longueur de mer = "+"mer".length());
		System.out.println("reussi = " + (2 == 1 + 1));
		System.out.println("valeur = " + x);
		System.out.println("poids = " + new Long(10) + " kilos");
		System.out.println(2 + 3 + " font " + 2 + 3);
		String chaine2 =  chaine.concat(" et la lune");
		System.out.println(chaine);
		System.out.println(chaine2);
	}
}
