package geometrie;

import java.awt.Color;
import javax.swing.*;

class EssaiTracable extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tracable[] desFormes = new Tracable[5];

	EssaiTracable()  {
	  setPreferredSize(new java.awt.Dimension(400, 400));
	  desFormes[0] = new CercleGraphique(150,200,200,Color.black);
	  desFormes[1] = new CercleGraphique(20,130,150, Color.blue);
	  desFormes[2] = new CercleGraphique(20,270,150, Color.blue);
	  //desFormes[3] = new CarreGraphique(20,200,220,Color.pink);
	  //desFormes[4] = new CarreGraphique(30,200,300, Color.magenta);
	  }

	  public void paintComponent(java.awt.Graphics g) {
		  	super.paintComponent(g);
	     	for (int i = 0;i < desFormes.length;i++)
							desFormes[i].dessine(g);
	  }

	  public static void main(String[] argv) {
			JFrame monCadre = new JFrame();
			monCadre.setContentPane(new  EssaiTracable());
			monCadre.pack();
			monCadre.setVisible(true); 
   }
}
