import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ardoise extends JPanel implements ActionListener {
	int dep = 0;
	Timer declencheur;
	int largeur = 200, hauteur = 200;

	Ardoise() {
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(Color.WHITE);
		declencheur = new Timer(100, this);
		declencheur.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == declencheur) {
			repaint();
			dep = (dep - 1) % 10;
		}
		else {
			String commande = e.getActionCommand();
			if (commande.equals("arreter"))
 				declencheur.stop();
			else if(commande.equals("reprendre"))
				declencheur.restart();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = dep - 5; i < largeur/2; i += 10) {
			for (int j = i; j < i + 5; j++)
				if (j > 0)
					g.drawOval(j, j, largeur - 2*j, hauteur - 2*j);
		}
	}
}

class Anneaux extends JFrame implements ActionListener {
	Ardoise ardoise = new Ardoise();
	JButton arret = new JButton("arret");
	JButton reprise = new JButton("reprendre");

	Anneaux() {
		arret.setActionCommand("arreter");
		arret.addActionListener(ardoise);
		arret.addActionListener(this);

		reprise.setActionCommand("reprendre");
		reprise.addActionListener(ardoise);
		reprise.addActionListener(this);
		reprise.setEnabled(false);

		JPanel boutons = new JPanel();
		boutons.setBackground(Color.WHITE);
		boutons.add(arret);
		boutons.add(reprise);

		setLayout(new BorderLayout());
		add(boutons, BorderLayout.NORTH);
		add(ardoise, BorderLayout.CENTER);
		setBackground(Color.WHITE); 

		pack();
		setLocation(100, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String commande =e.getActionCommand();
		if (commande.equals("arreter")) {
			arret.setEnabled(false);
			reprise.setEnabled(true);
		}
 		else if (commande.equals("reprendre")){
			arret.setEnabled(true);
			reprise.setEnabled(false);
		}
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Anneaux();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
