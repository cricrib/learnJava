import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Delegue implements ActionListener {
	Ardoise ardoise;

	Delegue(Ardoise _ardoise) {
		ardoise = _ardoise;
	}

	public void actionPerformed(ActionEvent e) { 
	    String commande = e.getActionCommand();
		if (commande.equals("tracer")) {
			ardoise.cercle = true;
			ardoise.repaint();
		}
		else if (commande.equals("effacer")) {
			ardoise.cercle = false;
			ardoise.repaint();
		}
	}
}

class Boutons4 extends JFrame {
	Boutons4() {	
		setLayout(new BorderLayout(5, 5));

		Ardoise ardoise = new Ardoise ();
		add(ardoise, BorderLayout.CENTER);
		Delegue delegue = new Delegue(ardoise);

		JPanel lesBoutons = new JPanel();

		JButton trace = new JButton("trace");
		trace.setActionCommand("tracer");
		trace.addActionListener(delegue);
		lesBoutons.add(trace);

		JButton efface = new JButton("efface");
		efface.setActionCommand("effacer");
		efface.addActionListener(delegue);
		lesBoutons.add(efface);

		add(lesBoutons, BorderLayout.NORTH);
		pack();
	}
}

class EssaiBoutons4 {
	public static void main(String[] arg) {
		JFrame fenetre = new Boutons4();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
