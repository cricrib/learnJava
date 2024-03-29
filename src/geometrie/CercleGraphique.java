package geometrie;

class CercleGraphique extends Cercle implements Tracable {
	private final int x, y; // coordonnŽes du centre
	java.awt.Color couleur = java.awt.Color.black;

	CercleGraphique(int rayon, int x, int y, java.awt.Color couleur) {
		super(rayon);
		this.couleur = couleur;
		this.x = x;
		this.y = y;
	}

	@Override
	public void dessine(java.awt.Graphics g) {
		if (rayon < DIM_MAX) {
			g.setColor(couleur);
			g.drawOval(this.x - this.rayon, this.y - this.rayon, 2 * rayon, 2 * rayon);
			int x = 0;
		}
	}

}
