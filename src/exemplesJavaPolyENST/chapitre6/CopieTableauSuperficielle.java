class CopieTableauSuperficielle {
	public static void main(String arg[])
	{
		int[] tableau = {1,2};
		int[] copieTableau;

		copieTableau = new int[2];
		System.arraycopy(tableau, 0, copieTableau, 0, tableau.length);
		copieTableau[0] = 4;
		System.out.println("tableau[0] contient " + tableau[0]);

		copieTableau = null;
		copieTableau = (int[])tableau.clone();
		copieTableau[0] = 3;
		System.out.println("tableau[0] contient " + tableau[0]);
	}
}