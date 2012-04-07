import java.io.*;
import java.util.StringTokenizer;

class PourRectangle extends javax.swing.JPanel {
	TraceRectangle applet;
	
	PourRectangle(TraceRectangle _applet) {
		applet = _applet;
	}

	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		if (applet.reussi)
			g.drawRect(applet.x, applet.y, 
applet.largeur, applet.hauteur);
		else
			g.drawString("erreur", 10, getHeight()/2);
	}
}

public class TraceRectangle extends javax.swing.JApplet {
    int x, y, largeur, hauteur;
    boolean reussi = true;

	public void init() {
	    java.io.InputStream entree = TraceRectangle.class.
		getResourceAsStream(getParameter("fichier")); 

	/* avec le JDK 5.0
		java.util.Scanner lecteur = new java.util.Scanner(entree);
		x = lecteur.nextInt();
		y = lecteur.nextInt();
		largeur = lecteur.nextInt();
		hauteur = lecteur.nextInt(); 
		getContentPane().add(new PourRectangle(this));
		lecteur.close();
	*/
	// avec les versions antérieures
	    try {
		
		BufferedReader lecteur = new BufferedReader(new InputStreamReader(entree));
		StringTokenizer st = new StringTokenizer
		    (lecteur.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		largeur = Integer.parseInt(st.nextToken());
		hauteur = Integer.parseInt(st.nextToken());	
		getContentPane().add(new PourRectangle(this));
	 	lecteur.close();
	    }
	    catch(Exception exc) {
		reussi = false;
	    }
	}
}
