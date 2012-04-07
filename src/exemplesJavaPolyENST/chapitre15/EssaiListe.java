import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Vector;

class Couleur extends Color {
	static final Couleur VERT = new Couleur(0, 255, 0);
	static final Couleur ROUGE = new Couleur(255, 0, 0);
	static final Couleur BLEU = new Couleur(0, 0, 255);

	Couleur(int r, int v, int b) {
			super(r, v, b);
	}

	public String toString() {
		if (equals(VERT)) return "vert";
		if (equals(ROUGE)) return "rouge";
		if (equals(BLEU)) return "bleu";
		return super.toString();
	}
}

class Ardoise extends JPanel {
	Couleur couleur;

	Ardoise() {
		setPreferredSize(new Dimension(100, 100));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(couleur);
		g.drawOval(10, 10, 80, 80);
	}
}

class EssaiListe extends JFrame 
implements ListSelectionListener {
	Ardoise ardoise = new Ardoise();
	JList liste;

	EssaiListe() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(ardoise);

		Vector<Couleur> listeItems = new Vector<Couleur>();
		listeItems.add(Couleur.VERT);
		listeItems.add(Couleur.ROUGE);
		listeItems.add(Couleur.BLEU);
		liste = new JList(listeItems);
		liste.setSelectedIndex(0);

		JScrollPane listeAvecAscenseur = new JScrollPane(liste);
		listeAvecAscenseur.setPreferredSize(new Dimension(80, 45));
		add(listeAvecAscenseur);
		liste.addListSelectionListener(this);

		ardoise.couleur = (Couleur)liste.getSelectedValue();
		pack();
	}

	public void valueChanged(ListSelectionEvent evt) { 
		ardoise.couleur = (Couleur)liste.getSelectedValue();
		ardoise.repaint();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiListe();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
