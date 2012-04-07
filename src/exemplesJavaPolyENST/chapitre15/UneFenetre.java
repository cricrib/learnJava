import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UneFenetre extends JFrame {
   UneFenetre(String titre) {
       super(titre);
       final JLabel etiquette = new JLabel("ouverture");
       final JTextField saisie = new JTextField(10);
 
       setLayout(new BorderLayout(5, 5));
       etiquette.setBorder(BorderFactory.createLineBorder(Color.BLUE));
       add(etiquette, BorderLayout.NORTH);
       add(saisie, BorderLayout.SOUTH);
	  
       saisie.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent evt) {
		   etiquette.setText(saisie.getText());
	       }
	   });
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setLocation(100, 100);
	setVisible(true);
    }
}



class AvecJDK5_0 {
    public static void main(String[] arg) {
	new UneFenetre("essai");
    }
}
