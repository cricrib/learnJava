import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ArdoisePourTracable extends JPanel {
	Tracable t;

	ArdoisePourTracable(Tracable t, int largeur, int hauteur) {
		this.t = t;
		setPreferredSize(new Dimension(largeur, hauteur));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		t.dessiner(g);
	}
}

class CercleDansFenetre {
	public static void main(String[] arg) {
		JFrame f = new JFrame() ;
		f.setContentPane(new ArdoisePourTracable
(new CercleGraphique(70,100,100,Color.red), 200, 200));
		f.pack() ;
		f.setVisible(true);
	}
}
