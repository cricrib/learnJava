import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ardoise extends JPanel {
	Ardoise() {
		setPreferredSize(new Dimension(140, 100));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(30, 10, 80, 80);
	}
}

class EssaiBoutonChoix extends JFrame implements ItemListener {
	JComboBox choix = new JComboBox();
	Ardoise ardoise = new Ardoise();
	Color autreCouleur = new Color(50, 100, 150);

	EssaiBoutonChoix() {
		choix.addItem("noir");
		choix.addItem("bleu");
		choix.addItem("vert");
		choix.addItem("autre");
		choix.addItemListener(this);

		JPanel panneau = new JPanel();
		panneau.add(choix);
		add(panneau, BorderLayout.NORTH);

		add(ardoise, BorderLayout.CENTER);
		pack();
	}

	public void itemStateChanged(ItemEvent evt) {
		Color couleur = getCouleur((String)choix.getSelectedItem());
		ardoise.setForeground(couleur);
	}

	Color getCouleur(String s) {
		if (s.equals("noir")) return Color.BLACK;
		else if (s.equals("bleu")) return Color.BLUE;
		else if (s.equals("vert")) return Color.GREEN;
		else if (s.equals("autre")) return autreCouleur;
		return Color.BLACK;
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiBoutonChoix();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100) ;
		fenetre.setVisible(true);
	}
}

