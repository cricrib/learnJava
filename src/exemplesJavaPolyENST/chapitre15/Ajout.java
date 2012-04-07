import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ajout extends JPanel {
	Ajout() {
		JButton ajouter = new JButton("ajouter");
		JButton supprimer = new JButton("supprimer");
		final JLabel texte = new JLabel("bonjour");

		texte.setOpaque(true);
		texte.setBackground(Color.PINK);
		setLayout(new BorderLayout());
		add(ajouter, BorderLayout.NORTH);
		add(supprimer, BorderLayout.SOUTH);
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(texte, BorderLayout.CENTER);
				revalidate();	// l'instruction à ne pas oublier
				repaint();
			}
		});		
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(texte);
				revalidate();	// l'instruction à ne pas oublier
				repaint();
			}
		});
	}

	public static void main(String[] arg) {
		JFrame fenetre = new JFrame("ajout");
		fenetre.add(new Ajout());
		fenetre.setSize(150, 150);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
