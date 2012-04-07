import java.awt.*;
import javax.swing.*;

class SansRepartiteur extends JFrame {
	SansRepartiteur() {
		setSize(new Dimension(200, 230));
		setLayout(null);

		JButton bouton = new JButton("bouton");
		bouton.setBounds(30, 10, 150, 30);
		add(bouton);

		JScrollPane ecriture = new JScrollPane(new JTextArea());
		ecriture.setSize(100, 100);
		ecriture.setLocation(20, 50);
		add(ecriture);

		JLabel message = new JLabel("Bonjour", SwingConstants.CENTER);
		message.setBackground(Color.BLACK);
		message.setForeground(Color.WHITE);
		message.setOpaque(true);
		message.setBounds(80, 170, 100, 20);
		add(message);
	}

	public static void main(String[] arg) {
		JFrame fenetre = new SansRepartiteur();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
