import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AppletBouton extends JApplet 
implements ActionListener {
	JButton bouton;

	public void init() {
		bouton = new JButton("applet " + getParameter("nom"));
		bouton.setForeground(Color.black);
		bouton.setBackground(Color.white);
		getContentPane().add(bouton);
		bouton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String autreNom = getParameter("autreApplet");
		AppletBouton autreApplet = (AppletBouton)
		    getAppletContext().getApplet(autreNom);
		JButton autreBouton = autreApplet.bouton;
		if (autreBouton.getForeground().equals(Color.white)) {
			autreBouton.setForeground(Color.black);
			autreBouton.setBackground(Color.white);
		}
		else {
			autreBouton.setForeground(Color.white);
			autreBouton.setBackground(Color.black);
		}
		showStatus("changement sur applet " + autreNom);
	}
}

