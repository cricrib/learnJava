class CercleGraphique extends Cercle implements Tracable {
	// x et y : coordonnees du centre du cercle
	int x, y;
	// couleur : la couleur du cercle
	java.awt.Color couleur;

	CercleGraphique(int rayon, int x, int y,
java.awt.Color couleur) {
		super(rayon);
		this.x = x;
		this.y = y;
		this.couleur = couleur;
	}

	public void dessiner(java.awt.Graphics g) {
		if (rayon < DIM_MAX) {
			g.setColor(couleur);
			g.drawOval(x - rayon, y - rayon, 2*rayon, 2*rayon);
		}
	}
}
