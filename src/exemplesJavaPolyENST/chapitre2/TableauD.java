class TableauD {
	public static void main(String[] arg) {
		NouveauPoint[] tableau = new NouveauPoint[2];
		int i;

		for (i = 0; i < tableau.length; i++)
			tableau[i] = new NouveauPoint(i, 2 * i);
		System.out.println(tableau[1].y);
	}
}
