class TableauDouble {
	public static void main(String[] arg) {
		int[][] tableau;
		int i, j;

		tableau = new int[2][3];
		for (i = 0; i < tableau.length; i++)
			for (j = 0; j < tableau[i].length; j++)
				tableau[i][j] = i + j;
		System.out.print(tableau[0][1] + " ");

		tableau = new int[2][];
		for (i = 0; i < tableau.length; i++) {
			tableau[i] = new int[i+2];
			for (j = 0; j < tableau[i].length; j++)
				tableau[i][j] = -(i + j);
		}
		System.out.println(tableau[0][1]);
	}
}
