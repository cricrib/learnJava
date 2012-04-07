import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

enum Niveau {
    FACILE, MOYEN, DIFFICILE;
}
class FenetreDialogueBis extends JDialog {
    FenetreDialogueBis(final Jeu jeu) {
	final JTextField champNom = new JTextField(10);
	JButton valider = new JButton("valider");
	JButton annuler = new JButton("Annuler");
		
	final JOptionPane panneauDialogue;
	setTitle("Choix");

	Object[] lesObjets =	{"Indiquez un nom",
				 "puis faites un choix",
				 "pour indiquer le niveau retenu",
				 champNom};
	Object[] choix = {FACILE, MOYEN, DIFFICILE};
	panneauDialogue = new JOptionPane(lesObjets,
					  JOptionPane.INFORMATION_MESSAGE,
					  0, null, choix);
	
	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	setContentPane(panneauDialogue);
	panneauDialogue.addPropertyChangeListener
	    (new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
			jeu.nom.setText(champNom.getValue());
		    }
		});
	    });setModal(true);
	valider.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    jeu.nom = champNom.getText();
		    jeu.niveau = choix.getOption();
		    dispose();
		}	   
	    });
	annuler.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    dispose();
		}	   
	    });
	pack();	
    }
}

class JeuBis extends JPanel {
    boolean aide;
    enum Niveau niveau;
    JLabel nom = new JLabel(" ");
    JLabel niveau = new JLabel(" ");
    JeuBis() {
	final JButton choix = new JButton("choix");
	
	texte.setEnabled(false);
	add(nom);
	add(niveau);
	choix.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    FenetreDialogue dialogue = 
			new FenetreDialogue(JeuBis.this);
		    aide.setText("le niveau est :  " + niveau);
		    if (aide)  texte.append("\naide");
		    else  texte.append("\npas d'aide");
		}	   
	    });
    }

    public static void main(String[] arg) {
	JFrame cadre = new JFrame("Jeu");
	cadre.setContentPane(new JeuBis());
	cadre.setLocation(100, 200);
	cadre.pack();
	cadre.setVisible(true);
    }
}

