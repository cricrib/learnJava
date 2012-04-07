import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class CercleGraphique {
	int x,y;
	Color couleur;
	int rayon;
	boolean plein;

	CercleGraphique(int _rayon, int _x, int _y,
Color _couleur, boolean _plein) {
		rayon = _rayon;
		x = _x;
		y = _y;
		couleur = _couleur;
		plein = _plein;
	}

	// retourne true ou false selon que le point de 
	// coordonnées et b est ou non dans le cercle
	boolean estDedans(int a, int b) {
		return (a > x - rayon) && (a < x + rayon) 
&& (b > y - rayon) && (b < y + 2 * rayon);
	}

	void dessiner(Graphics g) {
		g.setColor(couleur);
		if (plein) g.fillOval(x - rayon, y - rayon, 2*rayon, 2*rayon);
		else g.drawOval(x - rayon, y - rayon, 2*rayon, 2*rayon);
	}
}

class EssaiClics extends JPanel {
	ArrayList<CercleGraphique> memoire = 
new ArrayList<CercleGraphique>();
	Random alea = new Random();
	CercleGraphique cercleCourant;

	EssaiClics() {
		setPreferredSize(new Dimension(250, 250));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				if (cercleCourant != null) {
					memoire.remove(cercleCourant);
					repaint();
					return;
				}
				int rayon = 5;
				boolean plein = false;
				if (SwingUtilities.isMiddleMouseButton(evt)) rayon = 10;
				else if (SwingUtilities.isRightMouseButton(evt))
					rayon = 15;
				if ((evt.getModifiers() & MouseEvent.SHIFT_MASK) != 0)
					plein = true;
				cercleCourant = new CercleGraphique(rayon,
						evt.getX(),evt.getY(),
						new Color(Math.abs(alea.nextInt())),plein);
				memoire.add(cercleCourant);
				repaint();
				curseurCarre();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent evt) {
				cercleCourant = leCercle(evt.getX(), evt.getY());
				if (cercleCourant != null) curseurCarre();
				else setCursor(Cursor.getDefaultCursor());
			}
		});
	}

	// donne la forme d'une croix au curseur
	void curseurCarre() {
		setCursor(Cursor.getPredefinedCursor(
Cursor.CROSSHAIR_CURSOR));
	}

	// méthode qui retourne un CercleGraphique contenant le 
	// point de coordonnées a et b s'il en existe et null sinon
	CercleGraphique leCercle(int a, int b) {
		CercleGraphique trouve = null;
		for(CercleGraphique c : memoire) 
			if (c.estDedans(a, b)) trouve = c;
		return trouve;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(CercleGraphique c : memoire) c.dessiner(g);
	}

	public static void main(String[] arg) {
		JFrame fenetre = new JFrame();
		fenetre.add(new EssaiClics());
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
