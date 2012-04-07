import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Boutons1_sans extends JFrame implements ActionListener {
    JButton trace = new JButton("trace");
    JButton efface = new JButton("efface");
    Ardoise ardoise = new Ardoise();  // pour dessiner le cercle
    
    Boutons1_sans () {
	Container interieur = getContentPane();
	interieur.setLayout(new BorderLayout(5, 5));
	
	JPanel lesBoutons = new JPanel();  // pour les boutons
	lesBoutons.add(trace);
	lesBoutons.add(efface);
	interieur.add(lesBoutons, BorderLayout.NORTH);
	interieur.add(ardoise, BorderLayout.CENTER);
	
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

class EssaiBoutons1_sans {
    public static void main(String[] arg) {
	JFrame fenetre = new Boutons1_sans ();
	
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setLocation(100, 100);
	fenetre.setVisible(true);
    }
}

