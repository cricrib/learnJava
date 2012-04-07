import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Boutons2 extends JFrame {

	Boutons2() {
		final Ardoise ardoise = new Ardoise();
		add(ardoise, BorderLayout.CENTER);

		JPanel lesBoutons = new JPanel();
		final JButton trace = new JButton("trace");
		final JButton efface = new JButton("efface");

		lesBoutons.add(trace);
		class EcouteTrace implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ardoise.cercle = true;
				ardoise.repaint();
				trace.setEnabled(false);
				efface.setEnabled(true);
			}
		}
		trace.addActionListener(new EcouteTrace());

		lesBoutons.add(efface);
		efface.setEnabled(false);
		efface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ardoise.cercle = false;								ardoise.repaint();
				trace.setEnabled(true);
				efface.setEnabled(false);
			}
		});

		add(lesBoutons, BorderLayout.NORTH);
		pack();
	}
}

class EssaiBoutons2 {
	public static void main(String[] arg) {
		JFrame fenetre = new Boutons2();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
