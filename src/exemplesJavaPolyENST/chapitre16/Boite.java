import java.awt.*;
import javax.swing.*;

class Boite extends JFrame {
	Boite() {
	    	Box panneau = new Box(BoxLayout.Y_AXIS);

		JButton bouton = new JButton("bouton");
		bouton.setAlignmentX(Component.CENTER_ALIGNMENT);
		bouton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		panneau.add(bouton);

		add(Box.createVerticalStrut(10));

		JButton gBouton = new JButton("je suis un grand bouton");
		gBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panneau.add(gBouton);

		panneau.add(Box.createGlue());

		JLabel message = new JLabel("Bonjour");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		panneau.add(message);

		add(panneau);
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Boite(); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100); 
		fenetre.setVisible(true); 
	}
}
