import java.awt.*;
import javax.swing.*;

class PanneauImagesBis extends JPanel {
	Image lune, terre;
	MediaTracker surveillant;

	PanneauImagesBis() {
		setPreferredSize(new Dimension(200, 200));
		setBackground(Color.white);
		Toolkit boiteAOutils = getToolkit();
		surveillant = new MediaTracker(this);
		lune = boiteAOutils.getImage("../images/lune.gif");
		surveillant.addImage(lune,0);
		terre = boiteAOutils.getImage("../images/world.gif");
		surveillant.addImage(terre,0);
		try {
			surveillant.waitForID(0);
		}
		catch (InterruptedException e) {}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (surveillant.statusID(0, false) != MediaTracker.COMPLETE) {
			g.drawString("probleme de chargement d'image", 50, 100);
			return;
		}
		g.drawImage(lune, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(terre, 30, 30, this);
	}
}

class ImagesTrack extends JFrame {
	ImagesTrack() {
		setContentPane(new PanneauImagesBis());
	}

	public static void main(String[] arg) {
		ImagesTrack cadre = new ImagesTrack();
		cadre.pack();
		cadre.setVisible(true);
	}
}
