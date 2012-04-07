import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Boutons1 extends JFrame implements ActionListener {
	JButton trace = new JButton("trace");
	JButton efface = new JButton("efface");
	Ardoise ardoise = new Ardoise();  // pour dessiner le cercle

	Boutons1() {
	    setLayout(new BorderLayout(5, 5));

		JPanel lesBoutons = new JPanel();  // pour les boutons
		lesBoutons.add(trace);
		lesBoutons.add(efface);
		add(lesBoutons, BorderLayout.NORTH);
		add(ardoise, BorderLayout.CENTER);

		trace.addActionListener(this);
		efface.addActionListener(this);
		pack();	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == trace) ardoise.cercle = true;
		else ardoise.cercle = false;
		ardoise.repaint();
	}
}

class EssaiBoutons1 {
	public static void main(String[] arg) {
		JFrame fenetre = new Boutons1();
		System.out.println("Bouton1");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}