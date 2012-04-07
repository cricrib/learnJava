import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Ardoise extends JPanel implements ActionListener {
	Timer timer;
	int pas = 10;
	int x;
	Image image;
	int largeurImage;

	Ardoise() {
		setBackground(Color.YELLOW);
		timer = new Timer(100, this);
		timer.start() ;

}

	void construireImage() {
		Image terre;
		int largeurImage;
		String chaine = "Java est un beau langage et son " +
								"apprentissage est un vrai plaisir";
	
		try {
			terre = javax.imageio.ImageIO.read
			    (new File("../images/world.gif"));
			int largeurMonde = terre.getWidth(this);
			int hauteurMonde = terre.getHeight(this);
			Font fonte = new Font("TimesRoman",Font.PLAIN, 25);
			FontMetrics mesure = getFontMetrics(fonte);
			int hauteurChaine = mesure.getHeight();
			int largeurChaine = mesure.stringWidth(chaine);

			largeurImage = largeurChaine + largeurMonde + 10;
			int hauteurImage = (hauteurMonde > hauteurChaine ?
							hauteurMonde : hauteurChaine);
			int yChaine = (hauteurImage + mesure.getAscent())/2;

			image = createImage(largeurImage, hauteurImage);

			Graphics g = image.getGraphics();
			g.setColor(Color.YELLOW);
			g.fillRect(0, 0, largeurImage, hauteurImage);
			g.drawImage(terre, 0, (hauteurImage - hauteurMonde)/2, this);
			g.setFont(fonte);
			g.setColor(Color.RED);
			g.drawString(chaine, largeurMonde + 10, yChaine);
			g.dispose();
			javax.imageio.ImageIO.write
			    ((java.awt.image.BufferedImage)image, "jpeg",
			     new java.io.File("defile.jpg"));
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		x = x - pas;
	
		// si l'image est sortie sur la droite,
		// on la fait repartir de la gauche
		if (x < -largeurImage) x = getWidth();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		if (image == null) construireImage();
		g.drawImage(image, x, 40, this);
	}
}

class Defile extends JFrame {
	Defile() {
		add(new Ardoise());
		setSize(300, 150);
		setLocation(100, 100);
		setVisible(true);	
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Defile();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
