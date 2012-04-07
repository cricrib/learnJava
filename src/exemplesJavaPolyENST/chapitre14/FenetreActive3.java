import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FenetreActive3 extends JFrame {
	FenetreActive3() {
		setSize(100, 120);

		final JLabel etiquette = 
new JLabel("bonjour", SwingConstants.CENTER);
		add(etiquette, BorderLayout.CENTER);
		WindowAdapter adaptateur = new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				etiquette.setText("bonjour");
			}

			public void windowDeactivated(WindowEvent e) {
				etiquette.setText("");
			}
		};
		addWindowListener(adaptateur);
	}
}

class EssaiFenetreActive3 {
	public static void main(String[] arg) {
		JFrame fenetre = new FenetreActive3();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
} 
