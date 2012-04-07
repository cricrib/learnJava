import java.awt.*;
import javax.swing.*;

class Grille extends JFrame {
	Grille() {
		GridBagLayout repartiteur = new GridBagLayout();
		GridBagConstraints contraintes;

		setLayout(repartiteur);

		// pour la zone en haut à gauche
		JPanel dessin = new JPanel();
		dessin.setPreferredSize(new Dimension(100, 100));
		dessin.setBackground(Color.BLUE);

		// on crée "une fiche technique"
		contraintes = new GridBagConstraints();

		// on remplit la "fiche technique"
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 2;
		contraintes.fill = GridBagConstraints.BOTH;
		contraintes.weightx = 1;
		contraintes.weighty = 1;

		// on attache la "fiche technique" au sous-composant
		repartiteur.setConstraints(dessin, contraintes);

		// on ajoute le sous-composant au composant
		add(dessin);

		// pour le bouton "efface"
		JButton efface = new JButton("efface");
		contraintes = new GridBagConstraints();
		contraintes.gridwidth = GridBagConstraints.REMAINDER;
		contraintes.anchor = GridBagConstraints.SOUTH;
		contraintes.insets = new Insets(10, 10, 10, 10);
		contraintes.ipady = 20;
		repartiteur.setConstraints(efface, contraintes);
		add(efface);

		// pour le bouton "demarre"
		JButton demarre = new JButton("démarre");
		contraintes = new GridBagConstraints();
		contraintes.gridwidth = GridBagConstraints.REMAINDER;
		contraintes.anchor = GridBagConstraints.NORTH;
		contraintes.insets = new Insets(10, 10, 10, 10);
		repartiteur.setConstraints(demarre, contraintes);
		add(demarre);

		// pour le bouton à cocher "relief"
		JCheckBox relief = new JCheckBox("relief");
		contraintes = new GridBagConstraints();
		contraintes.ipady = 20;
		repartiteur.setConstraints(relief, contraintes);
		add(relief);

		// pour le bouton à cocher "gras"
		JCheckBox gras = new JCheckBox("gras");
		contraintes = new GridBagConstraints();
		contraintes.gridx = 0;
		repartiteur.setConstraints(gras, contraintes);
		add(gras);

		// pour le texte en bas à droite
		JTextArea texte = new JTextArea();
		contraintes = new GridBagConstraints();
		contraintes.gridwidth = GridBagConstraints.REMAINDER;
		contraintes.gridheight = GridBagConstraints.REMAINDER;
		contraintes.fill = GridBagConstraints.BOTH;
		contraintes.weightx = 1;
		contraintes.weighty = 1;
		repartiteur.setConstraints(texte, contraintes);
		add(texte); 
		pack();
	}

	public static void main(String[] arg) {
		Grille fenetre = new Grille();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
