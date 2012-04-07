class EcrivainJ {
	public static void main(String[] arg) {
		Repetiteur r1,r2,r3;

		r1 = new Repetiteur("soleil");
		r2 = new Repetiteur("neige");
		r3 = new Repetiteur("ski");
		r1.start();
		r2.start();
		r3.start();
		try {
			r1.join();
			r2.join();
			r3.join();
		}
		catch(InterruptedException exc) {}
		System.out.println("A la montagne");
	}
}
