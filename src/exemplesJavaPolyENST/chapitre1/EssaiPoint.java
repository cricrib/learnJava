class EssaiPoint {
	public static void main(String[] arg) {
		int abs = 1;
		Point p;

		p = new Point();
		p.x = abs;
		p.y = 2;
		System.out.println("coordonnees : " + p.x + " " + p.y);
		p.translate(3, 5);
		System.out.println("coordonnees : " + p.x + " " + p.y);
	}
}