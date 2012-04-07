import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/* Pour la fenêtre principale à partir de laquelle
on ouvre les différentes fenêtres de dialogue */
class EssaiDialogues extends JFrame implements ActionListener {
	JLabel etiquette = new JLabel("Essayer les différents boutons");
	JPanel lesBoutons = new JPanel();

	EssaiDialogues() {
		lesBoutons.setLayout(new GridLayout(4, 2));
		ajoute("dialogue1", "un simple avertissement");
		ajoute("dialogue2", "question avec boutons conventionnels");
		ajoute("dialogue3", "question avec boutons personnalisés");
		ajoute("dialogue4", "une façon de faire une saisie");
		add(lesBoutons, BorderLayout.CENTER);
		add(etiquette, BorderLayout.SOUTH);		
		pack();
	}

	void ajoute(String nom, String commentaire) {
		JButton bouton = new JButton(nom);

		bouton.setActionCommand(nom);
		bouton.addActionListener(this);
		lesBoutons.add(new JLabel(commentaire));
		lesBoutons.add(bouton);
	}

	public void actionPerformed(ActionEvent e) {
		String nom = e.getActionCommand();

		// Pour le dialogue1
		if (nom.equals("dialogue1")) 
			JOptionPane.showMessageDialog(this, 
					"Ce n'est qu'un simple message","avertissement",
					JOptionPane.WARNING_MESSAGE);

		// Pour le dialogue2
		else if (nom.equals("dialogue2")) {
			int r = JOptionPane.showConfirmDialog(this, 
					"Etes-vous de bonne humeur ?",
					"Boutons par defaut", JOptionPane.YES_NO_OPTION);

			if (r == JOptionPane.YES_OPTION)
				etiquette.setText("Bravo!");
			else if (r == JOptionPane.NO_OPTION)
				etiquette.setText("Courage!");
			else etiquette.setText("ni l'un ni l'autre ?");
		}

		// Pour le dialogue3
		else if (nom.equals("dialogue3")) {
			String[] choix = {"oui", "non", "pas d'opinion"};
			int r = JOptionPane.showOptionDialog(this, 
									"Etes-vous de bonne humeur ?",
									"Boutons personnalises", 
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, 
									null, choix, choix[2]);
			if (r == JOptionPane.YES_OPTION)
				etiquette.setText("Bravo!");
			else if (r == JOptionPane.NO_OPTION)
				etiquette.setText("Courage!");
			else etiquette.setText("Ni l'un ni l'autre ?");
		}

		// Pour le dialogue4
		else if (nom.equals("dialogue4")) {
			String reponse;
			String message = "Quel est votre nom ?";
			reponse = JOptionPane.showInputDialog(this, message);
			etiquette.setText(reponse);
		}

	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiDialogues();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}

