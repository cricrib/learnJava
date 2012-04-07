import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Classe utile pour la "deuxième" carte
class VoirCercle extends JPanel {
	JButton bouton = new JButton("trace");
	boolean cercle = false;

	VoirCercle() {
		add(bouton);
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cercle = !cercle;
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (cercle) g.fillOval(20, 50, 30, 30);
	}
}

class EssaiCartes extends JFrame implements ActionListener {
	JButton precedent = new JButton("precedent");
	JButton suivant = new JButton("suivant");
	JButton leMessage = new JButton("message");
	CardLayout gestionnaireDesCartes = new CardLayout();
	JPanel jeuCartes = new JPanel();// pour la partie droite

	EssaiCartes() {

		setLayout(new BorderLayout(5, 5));

		jeuCartes.setLayout(gestionnaireDesCartes);
		jeuCartes.setPreferredSize(new Dimension(100, 100));

		// Première carte
		JTextArea zone = new JTextArea("Un bel essai");
		jeuCartes.add(zone, "zone de texte");

		// Deuxième carte
		VoirCercle voirCercle = new VoirCercle();
		jeuCartes.add(voirCercle, "voir un cercle");

		// Troisième carte
		JLabel message = new JLabel("Bonjour", SwingConstants.CENTER);
		message.setOpaque(true);
		message.setBackground(Color.YELLOW);
		jeuCartes.add(message, "message bonjour");

		add(jeuCartes, BorderLayout.CENTER);

		precedent.addActionListener(this);
		suivant.addActionListener(this);
		leMessage.addActionListener(this);	

		JPanel p = new JPanel(); // pour la partie gauche
		p.setLayout(new GridLayout(3, 1));
		p.add(precedent);
		p.add(suivant);
		p.add(leMessage);
		add(p, BorderLayout.WEST);
		pack(); 
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == precedent) {
			gestionnaireDesCartes.previous(jeuCartes);
		}
		else if (obj == suivant) {
			gestionnaireDesCartes.next(jeuCartes);
		}
		else if (obj == leMessage) {
			gestionnaireDesCartes.show(jeuCartes, "message bonjour");
		}
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiCartes(); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true); 
	}
}

