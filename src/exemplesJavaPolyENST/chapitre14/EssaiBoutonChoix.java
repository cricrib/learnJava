import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ardoise extends JPanel {
	Ardoise() {
		setPreferredSize(new Dimension(140, 100));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(30,10,80,80);
	}
}

class EssaiBoutonChoix extends JPanel implements ItemListener {
	JComboBox choix = new JComboBox();
	Ardoise ardoise = new Ardoise();
	Color autreCouleur = new Color(50, 100, 150);

	EssaiBoutonChoix() {
		setLayout(new BorderLayout(5, 5));

		choix.addItem("noir");
		choix.addItem("bleu");
		choix.addItem("vert");
		choix.addItem("autre");
		choix.addItemListener(this);

		JPanel panneau = new JPanel();
		panneau.add(choix);
		add(panneau, BorderLayout.NORTH);

		add(ardoise, BorderLayout.CENTER);
	}

	public void itemStateChanged(ItemEvent evt) {
		ardoise.setForeground
			(getCouleur((String) choix.getSelectedItem()));
	}

	Color getCouleur(String s) {
		if (s.equals("noir")) return Color.black;
		else if (s.equals("bleu")) return Color.blue;
		else if (s.equals("vert")) return Color.green;
		else if (s.equals("autre")) return autreCouleur;
		return Color.black;
	}

	public static void main(String[] arg) {
		JFrame cadre = new JFrame();
		cadre.setContentPane(new EssaiBoutonChoix());
		cadre.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		cadre.setLocation(100, 100);
		cadre.pack();
		cadre.setVisible(true);
	}
}
