package geometrie;

class CercleGraphique extends Cercle implements Tracable {
	int x,y; 	// coordonnées du centre
  java.awt.Color couleur = java.awt.Color.black;
	CercleGraphique(int rayon, int x, int y, java.awt.Color couleur){
		super(rayon);
		this.couleur = couleur;
		this.x = x; 
		this.y = y; 
	}
	
	public void dessine(java.awt.Graphics g){
		if (rayon < DIM_MAX)  {
			g.setColor(couleur);
			g.drawOval(this.x - this.rayon, this.y - this.rayon, 2 * rayon, 2 * rayon);
	  }
	}

}
