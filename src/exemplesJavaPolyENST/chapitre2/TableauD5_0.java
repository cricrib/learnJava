class TableauD {
	public static void main(String[] arg) {
		Integer[] tableau = new Integer[3];
		int somme = 0;
		int i;

		for (i = 0; i < tableau.length; i++)
			tableau[i] = i + 1;
		for (Integer I : tableau)
			somme += I;
		System.out.println("Somme des entiers : " + somme);
	}
}
