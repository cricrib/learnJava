import javax.swing.*;
import java.awt.*; 
import java.io.*;
import javax.imageio.ImageIO;

class PanneauImages extends JPanel {
    Image lune, terre;
    
    PanneauImages() {
	try {
	    lune = ImageIO.read(new File("images/lune.gif"));
	    terre = ImageIO.read(new File("images/world.gif"));
	}
	catch(IOException exc) {
	    exc.printStackTrace();
	}
	setPreferredSize(new Dimension(200, 200));
	setBackground(Color.WHITE);
    }
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lune, 0, 0, getWidth(), getHeight(), this);
	g.drawImage(terre, 30, 30, this);
    }
}

class AfficheImages extends JFrame {
    AfficheImages() {
	add(new PanneauImages());
	pack();
	setLocation(100, 100);
	setVisible(true);
    }
    
    public static void main(String[] arg) {
	AfficheImages fenetre = new AfficheImages();
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

