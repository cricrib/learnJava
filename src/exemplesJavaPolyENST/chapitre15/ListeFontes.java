import java.awt.*;
import javax.swing.*;

class ListeFontes extends JFrame {
	ListeFontes() {
		GraphicsEnvironment gE = 
GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] liste = gE.getAvailableFontFamilyNames();

		setLayout(new GridLayout(18, 0, 5, 0));
		setBackground(Color.WHITE) ;
		for (String nom : liste) {
			JLabel etiquette = new JLabel();
			etiquette.setFont(new Font(nom, Font.PLAIN, 12));
			etiquette.setText(nom);
			add(etiquette);
		}
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new ListeFontes();
		fenetre.setLocation(100, 100);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
}

