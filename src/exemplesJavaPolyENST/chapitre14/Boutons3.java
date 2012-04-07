import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BoutonTrace extends JButton implements ActionListener {
	Ardoise ardoise;

	BoutonTrace(String nom, Ardoise ardoise) {
		super(nom);
		this.ardoise = ardoise;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		ardoise.cercle = true;
		ardoise.repaint();
	}
}

class BoutonEfface extends JButton implements ActionListener {
	Ardoise ardoise;

	BoutonEfface(String nom, Ardoise ardoise) {
		super(nom);
		this.ardoise = ardoise;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		ardoise.cercle = false;
		ardoise.repaint();
	}
}

class Boutons3 extends JFrame {
	Boutons3() {
		Ardoise ardoise = new Ardoise();

		setLayout(new BorderLayout(5, 5));
		add(ardoise, BorderLayout.CENTER);

		BoutonTrace trace = new BoutonTrace("trace", ardoise);
		BoutonEfface efface = new BoutonEfface("efface", ardoise);
		JPanel lesBoutons = new JPanel();
		lesBoutons.add(trace);
		lesBoutons.add(efface);
		add(lesBoutons, BorderLayout.NORTH);
		pack();
	}
}

class EssaiBoutons3 {
	public static void main(String[] arg) {
		JFrame fenetre = new Boutons3();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.show();
	}
}

