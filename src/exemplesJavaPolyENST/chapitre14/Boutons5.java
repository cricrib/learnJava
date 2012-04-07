import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// classe de l'interface
class Boutons5 extends JFrame {
	Boutons5(EssaiBoutons5 appli) {
		setLayout(new BorderLayout(5, 5));
		Aiguillage aiguillage = new Aiguillage(appli);

		JPanel ardoise = appli.ardoise;
		add(ardoise, BorderLayout.CENTER);

		JPanel lesBoutons = new JPanel();

		JButton trace = new JButton("trace");
		trace.setActionCommand("tracer");
		trace.addActionListener(aiguillage);
		lesBoutons.add(trace);

		JButton efface = new JButton("efface");
		efface.setActionCommand("effacer");
		efface.addActionListener(aiguillage);
		lesBoutons.add(efface);

		add(lesBoutons, BorderLayout.NORTH);
		pack();
	}
}

// classe d'aiguillage
class Aiguillage implements ActionListener {
    EssaiBoutons5 appli;
    
    Aiguillage(EssaiBoutons5 appli) {
	this.appli = appli;
    }
    
    public void actionPerformed(ActionEvent e) {	
	String commande = e.getActionCommand();
	if (commande.equals("tracer")){
	    appli.tracer();
	}
	else if (commande.equals("effacer")) {
	    appli.effacer();
	}
    }    
}

// classe de l'application
class EssaiBoutons5 {
	Ardoise ardoise = new Ardoise();

	void tracer() {			
		ardoise.cercle = true;
		ardoise.repaint();
	}

	void effacer() {
		ardoise.cercle = false;
		ardoise.repaint();
	}

	public static void main(String[] arg) {
		EssaiBoutons5 appli = new EssaiBoutons5();
		JFrame fenetre = new Boutons5(appli);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
