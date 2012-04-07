import javax.swing.*;
import java.awt.event.*;

class EssaiJLabel extends JPanel {
    
    EssaiJLabel() {
	ImageIcon icone = new ImageIcon("images/world.gif");
	JLabel afficheImage = new JLabel(icone);	
	add(afficheImage);

	final JLabel salut = new JLabel("bonjour   ");
	JButton bouton = new JButton("bascule");
	bouton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if (salut.getText().equals("bonjour")) salut.setText("au revoir");
		    else salut.setText("bonjour");
		    
		}
	    });
	add(bouton);
	add(salut);
	}

	public static void main(String[] arg) {
	    JFrame monCadre = new JFrame();
	    monCadre.setContentPane(new EssaiJLabel());
	    monCadre.setLocation(100, 100);
	    monCadre.pack();
	    monCadre.setVisible(true);
	}
}
