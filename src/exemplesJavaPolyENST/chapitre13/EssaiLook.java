import javax.swing.*;
import java.awt.*;

class Couleur extends Color {
	static final Couleur VERT = new Couleur(0, 255, 0);
	static final Couleur ROUGE = new Couleur(255, 0, 0);
	static final Couleur BLEU = new Couleur(0, 0, 255);
	static final Couleur JAUNE = new Couleur(0, 100, 50);

	Couleur(int r, int v, int b) {
			super(r, v, b);
	}

	public String toString() {
		if (equals(VERT)) return "vert";
		if (equals(ROUGE)) return "rouge";
		if (equals(BLEU)) return "bleu";
		if (equals(BLEU)) return "bleu";
		if (equals(JAUNE)) return "jaune";
		return super.toString();
	}
}

class EssaiLook extends JFrame {
    EssaiLook(String style) throws Exception {
	if (style.equals("metal"))
	    UIManager.setLookAndFeel
		("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

	JPanel panneauChoix =  new JPanel();
	JPanel panneauRadio =  new JPanel();
	
	setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	panneauChoix.setLayout(new BorderLayout());
	panneauRadio.setLayout(new GridLayout(2, 1));
	panneauRadio.setBorder
	    (BorderFactory.createLineBorder(Color.BLACK));
	JRadioButton petit = new JRadioButton("petit", true);
	JRadioButton grand = new JRadioButton("grand", false);
	panneauRadio.add(petit);
	panneauRadio.add(grand);  
	JPanel panneau = new JPanel();
	panneau.add(panneauRadio);
	panneauChoix.add(panneau, BorderLayout.CENTER);
	panneauChoix.add(new JCheckBox("Metal"), BorderLayout.SOUTH); 
	add(panneauChoix); 
			 
	java.util.Vector<Couleur> listeItems = 
	    new java.util.Vector<Couleur>();
	listeItems.add(Couleur.VERT);
	listeItems.add(Couleur.ROUGE);
	listeItems.add(Couleur.BLEU);
	listeItems.add(Couleur.JAUNE);
	JList liste = new JList(listeItems);
	liste.setSelectedIndex(0);
	
	JPanel panneauAsc = new JPanel();

	JScrollPane listeAvecAscenseur = new JScrollPane(liste);
	listeAvecAscenseur.setPreferredSize(new Dimension(80, 60));
	panneauAsc.add(listeAvecAscenseur);
	add(panneauAsc);

	setSize(180, 120);
    }

    public static void main(String[] arg) throws Exception {
	JFrame fenetre = new EssaiLook(arg[0]);
	System.out.println(new JPanel());
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setLocation(100, 100);
	fenetre.setVisible(true);
    }
}
