import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Disque {
	int rayon, x, y;

	public Disque(int rayon, int x, int y) {
		this.rayon = rayon;
		this.x = x;
		this.y = y;
	}

	void dessiner(Graphics g) {
		g.setColor(Color.MAGENTA) ;
		g.fillOval(x - rayon, y - rayon, 2 * rayon, 2 * rayon);
	}
}

class Ardoise extends JPanel {
	ArrayList<Disque> memoire = new ArrayList<Disque>();
	Color couleur = Color.MAGENTA;

	Ardoise() {
		setPreferredSize(new Dimension(500, 1000));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				int x = evt.getX(), y = evt.getY();
				Graphics g = getGraphics();

				g.setColor(couleur);
				Disque c = new Disque(20, x, y);
				c.dessiner(g) ;
				g.dispose();
				memoire.add(c);;
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Disque disque : memoire) disque.dessiner(g);
	}
}

class EssaiScrollPane extends JFrame {
	EssaiScrollPane() {
		JScrollPane ascenseurs = new JScrollPane(new Ardoise());
		ascenseurs.setPreferredSize(new Dimension(300, 300));
		add(ascenseurs);
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiScrollPane(); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true); 
	}
}

