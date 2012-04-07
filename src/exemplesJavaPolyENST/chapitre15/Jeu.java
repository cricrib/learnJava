import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class FenetreDialogue extends JDialog {
	FenetreDialogue(final Jeu jeu) {
		JButton valider = new JButton("Valider");
		JButton annuler = new JButton("Annuler");
		final JTextField champNom = new JTextField(10);
		final JCheckBox choixAide = new JCheckBox("choix de l'aide");
		JPanel panneau ;

		Box boite = Box.createVerticalBox();
		setModal(true);
		setTitle("Choix");

		panneau = new JPanel();
		panneau.add(new JLabel("nom : "));
		panneau.add(champNom);
		boite.add(panneau);

		panneau = new JPanel();
		panneau.add(choixAide);
		boite.add(panneau);

		panneau = new JPanel();
		panneau.add(valider);
		panneau.add(annuler);
		boite.add(panneau);

		add(boite) ;

		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jeu.nom = champNom.getText();
				jeu.aide = choixAide.isSelected();
				dispose();
			}
		});
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		pack();
		setLocation(400, 200);
		setVisible(true);
	}
}

class Jeu extends JFrame {
	String nom;
	boolean aide;
	Jeu(String titre) {
		super(titre);
		final JButton choix = new JButton("choix");
		final JTextArea texte = new JTextArea(2, 12);

		setLayout(new FlowLayout());
		texte.setEditable(false);
		add(choix);
		add(texte);
		choix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				FenetreDialogue dialogue = 
new FenetreDialogue(Jeu.this);
				texte.setText("le nom est " + nom);
				if (aide) texte.append("\naide");
				else texte.append("\npas d'aide");
			}
		});
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Jeu("Jeu");;
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		fenetre.setLocation(100, 200);
		fenetre.setVisible(true);
	}
}
