class Copie {
	public static void main(String arg[]) {
		int[] tableau = {1,2};
		int[] table =  new int[tableau.length];

		System.arraycopy(tableau, 0, table, 0, tableau.length);
		table[0] = 3;
		System.out.println("tableau contient : " + tableau[0]+", " + tableau[1]);
	}
}