class EssaiTrier {
	public static void main(String[] arg) {
		java.util.Random alea =
			new java.util.Random(System.currentTimeMillis());
		int nbEleves = 10;
		Eleve[] eleves = new Eleve[nbEleves];
		int i;

 		for (i = 0; i < nbEleves; i++)
		eleves[i] = new Eleve(Math.abs(alea.nextInt())%21);

		for (i = 0; i < nbEleves; i++)
			System.out.print(eleves[i].note + " ");
		System.out.println();
		java.util.Arrays.sort(eleves);
		for (i = 0; i < nbEleves; i++)
			System.out.print(eleves[i].note + " ");
		System.out.println();
	}
}
