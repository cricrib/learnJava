class PointEntier {
	int x, y;

	PointEntier(int abs, int ord) {
		x = abs;
		y = ord;
	}

public static void main(String[] arg) {
		PointEntier p = new PointEntier(1, 2);

		System.out.println("Abscisse " + p.x + ", ordonnee " + p.y);
	}
}
