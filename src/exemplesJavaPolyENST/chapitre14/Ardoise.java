import javax.swing.JPanel;
import java.awt.*;

class Ardoise extends JPanel {
    boolean cercle;
    Ardoise() {
	setBackground(Color.WHITE);
	setPreferredSize(new Dimension(200, 150));
    }
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	if (cercle) {
	    g.setColor(Color.RED);
	    g.drawOval(50,20,100,100);
	}
    }
}
