import java.util.Properties;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MonDessin extends JPanel {
	MonDessin() {
		setPreferredSize(new Dimension(180, 120));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(50, 20, 80, 80);
	}
}

class Imprimer extends JFrame implements ActionListener {
	MonDessin dessin = new MonDessin();
	JButton imprimer = new JButton("imprimer");
	JRadioButton choixTout = new JRadioButton("tout", true);
	JRadioButton choixDessin = new JRadioButton("dessin", false);

	Imprimer() {
		ButtonGroup choix = new ButtonGroup();
		choix.add(choixTout);
		choix.add(choixDessin);

		JPanel p = new JPanel();
		p.add(choixTout);
		p.add(choixDessin);
		add(p, BorderLayout.NORTH);
		add(dessin, BorderLayout.CENTER);
		add(imprimer, BorderLayout.SOUTH);

		imprimer.addActionListener(this);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		Properties props = new Properties();

		props.setProperty("awt.print.paperSize", "a4");
		props.setProperty("awt.print.destination", "printer");

		PrintJob demandeDImpression = getToolkit().
getPrintJob(this, "Impression", props);
		if (demandeDImpression != null) {
			Graphics gImpr = demandeDImpression.getGraphics();

			if (choixTout.isSelected()) printAll(gImpr);
			else dessin.printAll(gImpr);
			gImpr.dispose();
			demandeDImpression.end();
		}
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Imprimer(); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
