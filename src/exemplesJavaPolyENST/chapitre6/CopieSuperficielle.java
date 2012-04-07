class Entier {
	int n = 2;
}

class B implements Cloneable {
	int m = 1;
	Entier entier = new Entier();

	protected Object clone() throws CloneNotSupportedException {
		return super.clone() ;
	}

}

class CopieTableauSuperficielle {
	public static void main(String arg[]) //throws CloneNotSupportedException
	{
		int[] tableau = {1,2};
		int[] copieTableau;
		B b = new B();
		B copie_b;

		copieTableau = (int[])tableau.clone();
		//copie_b = (B)b.clone();
		copieTableau[0] = 3;
		System.out.println("copieTableau[0] contient " +
			copieTableau[0]);
		/*copie_b.m = 3;
		System.out.println("b.m contient : " + b.m);
		copie_b.entier.n = 3;
		System.out.println("b.entier.n contient : " + b.entier.n);
	*/}
}
