import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

class EssaiTracable extends JPanel {
	Tracable[] desFormes = new Tracable[5];

	EssaiTracable() {

	setPreferredSize(new Dimension(200, 200));
		desFormes[0] = new CercleGraphique(75, 100, 100, Color.black);
		desFormes[1] = new CercleGraphique(10, 65, 75, Color.blue);
		desFormes[2] = new CercleGraphique(10, 135, 75, Color.blue);
		desFormes[3] = new CarreGraphique(10, 100, 110, Color.magenta);
		desFormes[4] = new CarreGraphique(15, 100, 150, Color.red);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0;i < desFormes.length;i++) desFormes[i].dessiner(g);
	}

	public static void main(String[] arg) {
		JFrame monDessin = new JFrame();
		monDessin.setContentPane(new EssaiTracable()) ;
		monDessin.pack();
		monDessin.setVisible(true);
	}
}
