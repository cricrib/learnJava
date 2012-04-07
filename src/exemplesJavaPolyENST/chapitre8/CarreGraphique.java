import java.awt.*;

class CarreGraphique extends Carre implements Tracable {
	int x, y;							//coordonnees du centre
	Color couleur = Color.black;	// couleur par défaut du carre

	CarreGraphique(int cote, int x, int y) {
		super(cote);
		this.x = x;
		this.y = y;
	}

	CarreGraphique(int cote, int x, int y, Color couleur) {
		this(cote, x, y);
		this.couleur = couleur;
	}

	public void dessiner(Graphics g) {
		if (cote < DIM_MAX) {
			g.setColor(couleur);
			g.drawRect(x - cote/2, y - cote/2, cote, cote);
		}
	}
}
