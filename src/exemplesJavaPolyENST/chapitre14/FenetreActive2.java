import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ActionsFenetre2 extends WindowAdapter {
	JLabel etiquette;

	ActionsFenetre2(JLabel etiquette) {
		this.etiquette = etiquette;
	}

	public void windowActivated(WindowEvent e) {
		etiquette.setText("bonjour");
	}

	public void windowDeactivated(WindowEvent e) {
		etiquette.setText("");
	}
}

class FenetreActive2 extends JFrame{
	FenetreActive2 () {
		setSize(100, 120);

		JLabel etiquette = 
new JLabel("bonjour", SwingConstants.CENTER);
		add(etiquette, BorderLayout.CENTER);
		ActionsFenetre2 actions = new ActionsFenetre2(etiquette);
		addWindowListener(actions);
	}
}

class EssaiFenetreActive2 {
	public static void main(String[] arg) {
		JFrame fenetre = new FenetreActive2();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}

