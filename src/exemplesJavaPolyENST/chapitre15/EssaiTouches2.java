import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// pour le mode d'emploi affiché dans la fenêtre
class Indication extends JPanel {
	int h;
	Indication() {
		Font fonte = new Font("TimesRoman", Font.BOLD|Font.ITALIC, 14);
		setFont(fonte);
		FontMetrics fM = getFontMetrics(fonte);
		h = fM.getHeight();
		int largeur = fM.stringWidth 
("bouton droit + b pour voir un disque bleu");
		setPreferredSize(new Dimension(largeur + 40, 6*h + 30));
	}

	public void paintComponent(Graphics g) {
		int x = 10, y = 40;

		g.drawString(" r pour voir un cercle rouge", x, y);
		y += h;
		g.drawString(" CTRL + r pour voir un disque rouge", x, y);
		y += h;
		g.drawString(" b pour voir un cercle bleu", x, y);
		y += h;
		g.drawString(" bouton droit + b " +
 "pour voir un disque bleu", x, y);
		y += h;
		g.drawString(" barre d'espace " +
 "pour descendre le cercle", x, y);
		y += h;
		g.drawString(" touche \"arrière\" pour repositionner " +
 "le cercle", x, y);
	}
}

// pour afficher le dessin
class Ardoise extends JPanel {
	Color couleur = Color.BLUE;
	boolean plein = false;
	int hauteur = 20;

	Ardoise() {
		setPreferredSize(new Dimension(0, 200)); 
	}

	public void paintComponent(Graphics g) {
		int largeur = getWidth();

		super.paintComponent(g);
		g.setColor(couleur);
		if (plein) g.fillOval((largeur - 100)/2, hauteur, 100, 100);
		else g.drawOval((largeur - 100)/2, hauteur, 100, 100);
	}
}

// pour le conteneur de la fenêtre
class EssaiTouches2 extends JPanel implements KeyListener {
	Ardoise ardoise = new Ardoise();
	EssaiTouches2() {
		setLayout(new BorderLayout());
		add(new Indication(), BorderLayout.NORTH);
		add(ardoise, BorderLayout.CENTER);
		addKeyListener(this);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				requestFocus();
			}
		});
	}

	public void keyPressed(KeyEvent evt) {
		int code = evt.getKeyCode();

		if (code == KeyEvent.VK_R) {
			ardoise.couleur = Color.RED;
			if (evt.isControlDown()) ardoise.plein = true;
			else ardoise.plein = false;
		}
		else if (code == KeyEvent.VK_B) {
			ardoise.couleur = Color.BLUE;
			if ((evt.getModifiersEx() 
& InputEvent.BUTTON3_DOWN_MASK) != 0)
				ardoise.plein = true;
			else ardoise.plein = false;
		}
		else if (code == KeyEvent.VK_SPACE) ardoise.hauteur = 80;
		else if (code == KeyEvent.VK_BACK_SPACE) ardoise.hauteur = 20;
		repaint();
	}

	public void keyTyped(KeyEvent evt) {}
	public void keyReleased(KeyEvent evt) {}

	public static void main(String[] arg) {
		final JFrame fenetre = new JFrame("Essai des touches");
		final Container interieur = new EssaiTouches2();
		fenetre.add(interieur);
		fenetre.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) { 
				interieur.requestFocus();
			}
		});
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
