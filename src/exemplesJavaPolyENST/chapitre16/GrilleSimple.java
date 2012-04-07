import java.awt.*;
import javax.swing.*;

class GrilleSimple extends JFrame {
	JButton efface = new JButton("efface");
	JButton demarre = new JButton("démarre");
	JCheckBox relief = new JCheckBox("relief");
	JCheckBox gras = new JCheckBox("gras");
	JTextArea texte = new JTextArea();
	JPanel dessin = new JPanel();

	GrilleSimple() {
		texte.setPreferredSize(new Dimension(100, 100));
		dessin.setPreferredSize(new Dimension(50, 50));
		dessin.setBackground(Color.BLUE);
		setLayout(new GridLayout(2, 3));
		add(texte);
		add(relief);
		add(demarre);
		add(dessin);
		add(gras);
		add(efface);
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new GrilleSimple();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}

