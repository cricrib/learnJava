import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Ardoise extends JPanel implements ActionListener  {
    int heure = 1;
    
    Ardoise() {
	setPreferredSize(new Dimension(200, 150));
	setBackground(Color.white);
	Timer timer = new Timer(1000, this);
	timer.start();
    }
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawString(Long.toString(heure), getWidth()/2, getHeight()/2);
    }

    public void actionPerformed(ActionEvent e) {
	heure++;
	repaint();
    }
}

public class AppliCompteur {
    public static void main(String[] arg) {
	Ardoise ardoise = new Ardoise();
	JFrame fenetre = new JFrame("compteur");
	fenetre.add(ardoise);
	fenetre.pack();
	fenetre.setVisible(true);	    
    }
}

//pour le jar : jar cvfm AppliCompteur.jar  AppliCompteur.mf AppliCompteur.class

