import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ardoise extends JPanel {
	boolean peindre = false;  // sert pour effacer

	Ardoise() {
		setPreferredSize(new Dimension(100, 100));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!peindre) return;
		int largeur = getWidth();
		int hauteur = getHeight();
		g.fillOval(10, 10, largeur - 20, hauteur - 20);
	}
}

class Panneau extends JPanel implements KeyListener {
	Ardoise ardoise = new Ardoise();

	Panneau() {
		JPanel indications = new JPanel();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		indications.setLayout(new GridLayout(4, 1));
		indications.add(new JLabel(" touche r : disque rouge"));
		indications.add(new JLabel(" touche b : disque bleu"));
		indications.add(new JLabel(" touche v : disque vert"));
		indications.add(new JLabel(" touche e : effacer"));

		setLayout(new BorderLayout(5, 5));
		add(indications, BorderLayout.NORTH);
		add(ardoise, BorderLayout.CENTER);
		addKeyListener(this);
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent evt) {
				requestFocus();
			}
		});
	}

	public void keyPressed(KeyEvent evt) {}
	public void keyReleased(KeyEvent evt) {}
	public void keyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == 'r') {
			ardoise.peindre = true;
			ardoise.setForeground(Color.RED);
		}
		else if (evt.getKeyChar() == 'b') {
			ardoise.peindre = true;
			ardoise.setForeground(Color.BLUE);
		}
		else if (evt.getKeyChar() == 'v') 	{
			ardoise.peindre = true;
			ardoise.setForeground(Color.GREEN);
		}
		else if (evt.getKeyChar() == 'e')
			ardoise.peindre = false;
		ardoise.repaint();
	}
}

class EssaiTouches extends JFrame {
	EssaiTouches() {
	    setLayout(new FlowLayout());
		add(new Panneau());
		add(new Panneau());
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiTouches();
		fenetre.setTitle("Essai des touches");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
