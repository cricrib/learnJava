import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ActionsFenetre1 implements WindowListener {
	JLabel etiquette;

	ActionsFenetre1 (JLabel etiquette) {
		this.etiquette = etiquette;
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {
		etiquette.setText("bonjour");
	}

	public void windowDeactivated(WindowEvent e) {
		etiquette.setText("");
	}

	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
}

class FenetreActive1 extends JFrame {
	FenetreActive1() {
		setSize(100, 120);

		JLabel etiquette = 
new JLabel("bonjour", SwingConstants.CENTER);
		add(etiquette, BorderLayout.CENTER);
		ActionsFenetre1 actions = new ActionsFenetre1(etiquette);
		addWindowListener(actions);
	}
}

class EssaiFenetreActive1 {
	public static void main(String[] arg) {
		JFrame fenetre = new FenetreActive1();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}

