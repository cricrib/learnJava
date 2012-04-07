import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;

class EssaiTexte extends JFrame implements ActionListener,
CaretListener {
	JLabel commentaire = new JLabel("  Vous pouvez ecrire");
	JTextField saisieTaille = new JTextField(5);
	JTextArea grandeZone = new JTextArea(4, 15);
	int position ;
	EssaiTexte() {
		// pour la partie au nord de la fenêtre
		JPanel panneauTaille = new JPanel();

		ImageIcon icone = new ImageIcon("../images/world.gif");
		JLabel afficheImage = new JLabel(icone);	
		panneauTaille.add(afficheImage);

		JLabel etiquetteTaille = new JLabel
("  Taille de la fonte : ", SwingConstants.RIGHT);
		panneauTaille.add(etiquetteTaille);
		saisieTaille.setText("20");
		panneauTaille.add(saisieTaille);
		add(panneauTaille, BorderLayout.NORTH); 
		saisieTaille.addActionListener(this);

		// pour la partie centrale de texte
		int tailleFonte = Integer.parseInt(saisieTaille.getText());
		Font fonte = new Font("TimesRoman", Font.PLAIN, tailleFonte);
		grandeZone.setFont(fonte);
		grandeZone.setText("Bonjour");
		JScrollPane texteAsc = new JScrollPane(grandeZone);
		add(texteAsc, BorderLayout.CENTER);
		grandeZone.addCaretListener(this);

		Document document = grandeZone.getDocument();
		document.addDocumentListener(new EcouteDocument(this));

		add(commentaire, BorderLayout.SOUTH);
		pack();
	}

	public void actionPerformed(ActionEvent evt) {
		int taillePolice;

		try {
			taillePolice = Integer.parseInt(saisieTaille.getText());
			grandeZone.setFont(new Font("TimesRoman", 
Font.PLAIN, taillePolice));
		}
		catch(NumberFormatException exc) {}
	}

	public void caretUpdate(CaretEvent evt) {
		if (evt.getMark() != evt.getDot())
			commentaire.setText("  Selection de caracteres");
		else position = evt.getDot();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiTexte();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}

// sert de "delegue" pour la fenêtre centrale de texte
class EcouteDocument implements DocumentListener {
	JLabel etiquette;
	EssaiTexte panneau;
	
EcouteDocument(EssaiTexte _panneau) {
		panneau = _panneau;
		etiquette = panneau.commentaire;
	}

	public void insertUpdate(DocumentEvent e) {
		etiquette.setText("  Insertion du " +
 (panneau.position  + 1) + " eme caractere");
	}

	public void removeUpdate(DocumentEvent e) {
		etiquette.setText("  Suppression du " +
 panneau.position + " eme caractere");
	}

	public void changedUpdate(DocumentEvent e) {}
}
