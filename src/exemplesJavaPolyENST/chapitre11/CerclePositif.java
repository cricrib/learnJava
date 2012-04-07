public class CerclePositif {
	private int rayon;
	private int largeur;

	public CerclePositif(int r) {
		if (r > 0) rayon = r;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int r) {
		if (r > 0) rayon = r;
		else rayon = 0;
	}
}