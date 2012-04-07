import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random; 
import java.io.*;
import javax.imageio.*;

class Ardoise extends JPanel implements ActionListener {
	Timer declencheur;
	Random alea;
	Image terre;
	int largeur = 400, hauteur = 200;
	int r, v, b;
	int x; // abscisse du coin supérieur gauche de l'image
	int largeurImage = 50; // largeur de l'image
	int hauteurImage = 50; // hauteur de l'image
	Rectangle vieuxRectangle;

	Ardoise() {
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(Color.BLUE);
		alea = new Random();
		getCouleurs();
		x = - largeurImage - 5;
		try {
			terre = ImageIO.read(new File("../images/world.gif"));
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
		x = - largeurImage - 5;
		vieuxRectangle = new Rectangle(0, 0, 0, 0); 
		declencheur = new Timer(100, this);
		declencheur.start();
	}

	void getCouleurs() {
		r = Math.abs(alea.nextInt())%256;
		v = Math.abs(alea.nextInt())%256;
		b = Math.abs(alea.nextInt())%256;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == declencheur) {
			x += 5;
			if (x > getWidth()) x = - largeurImage;

			// on calcule l'union de l'ancien rectangle
			// contenant l'image et du nouveau rectangle
			Rectangle nouveauRectangle = new Rectangle(
x, getHeight()/3, largeurImage , hauteurImage);
			Rectangle rect = nouveauRectangle.union(vieuxRectangle);
			vieuxRectangle = nouveauRectangle;

			// on repeint uniquement l'union des rectangles 
			repaint(rect.x, rect.y, rect.width, rect.height);
		}

		else {
			String commande = e.getActionCommand();
			if (commande.equals("arreter"))declencheur.stop();
			else if (commande.equals("reprendre"))
declencheur.restart();
			else if (commande.equals("changerCouleurs")) {
				getCouleurs();
				repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		largeur = getWidth();
		hauteur = getHeight();
		for (int i = 0 ; i < largeur; i++) {
			g.setColor(new Color((r + i/3)%255,
(v + i)%255,(b + i/2)%255));
			g.drawArc(i, i, largeur - 2*i, 2*hauteur - 2*i, 0, 180);
		}
		if (terre != null) g.drawImage(terre, x, getHeight()/3,
 largeurImage, hauteurImage, this);
	}
}

class Mouvement extends JFrame implements ActionListener {
	JButton arret = new JButton("arret");
	JButton reprise = new JButton("reprendre");
	JButton couleurs = new JButton("couleurs");
	Ardoise ardoise = new Ardoise();

	Mouvement() {
		arret.setActionCommand("arreter");
		arret.addActionListener(ardoise);
		arret.addActionListener(this);

		reprise.setActionCommand("reprendre");
		reprise.addActionListener(ardoise);
		reprise.addActionListener(this);
		reprise.setEnabled(false);

		couleurs.setActionCommand("changerCouleurs");
		couleurs.addActionListener(ardoise);

		JPanel boutons = new JPanel();		
		boutons.setBackground(Color.BLUE);
		boutons.add(arret);
		boutons.add(reprise);
		boutons.add(couleurs);

		setLayout(new BorderLayout());
		add(boutons, BorderLayout.NORTH);
		add(ardoise, BorderLayout.CENTER);


		pack();
		setLocation(100, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("arreter")) {
			arret.setEnabled(false);
			reprise.setEnabled(true);
		}

		else if (e.getActionCommand().equals("reprendre")) {
			arret.setEnabled(true);
			reprise.setEnabled(false);
		}
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Mouvement();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
