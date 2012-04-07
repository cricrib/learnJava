class EssaiNouveauPoint {
	public static void main(String[] arg) {
		NouveauPoint p = new NouveauPoint(1, 2);
		NouveauPoint q;

		q = p;
		p.translate(3, 5);
		System.out.println("Abscisse de p : " + p.x);
		System.out.println("Abscisse de q : " + q.x);
	}
}
