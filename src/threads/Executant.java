package threads;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Executant implements Runnable
{
  Color couleur=Color.RED;
  JPanel panneau;
  int x = -10;
  int y = 100;
  
  public Executant(JPanel panneau)
  {
      this.panneau = panneau;
  }
    
    public void initialiser()
    { 
	couleur=Color.RED;
	x = -10;
	y = 100;
    }
    
    public void run()
    {
	Graphics g = panneau.getGraphics();
	Color laCouleur;
	
	try
	    {
		if (couleur == Color.RED) couleur = Color.BLUE;
		else couleur = Color.RED;
		laCouleur = couleur;
		g.setColor(laCouleur);
		x += 5;
		y = 100;
		g.drawOval(x, y, 70, 80);
		Thread.sleep(1000);
		g.setColor(laCouleur);
		x += 10;
		y += 25;
		g.drawOval(x, y,10,10);
		System.out.flush(); 
		Thread.sleep(1000);
		g.setColor(laCouleur);
		x += 40;
		g.drawOval(x, y,10,10);
		System.out.flush();
		Thread.sleep(1000);
		g.setColor(laCouleur);
		x -= 19;
		y += 13;
		g.drawOval(x, y, 8,12);
		System.out.flush();
		Thread.sleep(1000);
		g.setColor(laCouleur);
		y += 22;
		x -= 6;
		g.drawOval(x, y, 20, 5);
		System.out.flush();
		Thread.sleep(1000);
	    }
	catch (InterruptedException e){
	    System.out.println("interruption");
	}
  }
}
