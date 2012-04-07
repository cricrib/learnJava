class TableauC {
	public static void main(String[] argv) {
		int[] tableau = new int[3];

		System.out.println("Taille du tableau : " + tableau.length);
		try {
			tableau[tableau.length] = 1;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + ", bien intercepte!");
		}
	}
}
