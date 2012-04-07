class TableauSinus {
	static double[] desSinus = new double[10];

	static {
		for (int i = 0;i < desSinus.length;i++) 
desSinus[i] = Math.sin(i*Math.PI/20);
	}

	public static void main(String arg[]) {
		System.out.println(TableauSinus.desSinus[1]);
	}
}
