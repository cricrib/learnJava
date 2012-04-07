import javax.swing.*;

class Son {
    static java.applet.AudioClip avoirSon(String fichier) {
	java.net.URL url = Son.class.getResource(fichier);
	return java.applet.Applet.newAudioClip(url); 
    }

    static java.applet.AudioClip avoirSonBis(String fichier) {
	String nomFichier = "oiseau.au";	
	java.net.URL url = null; 
	try {	
	    url = new java.net.URL
		("file:" +  System.getProperty("user.dir") + "/" +  fichier);
	} 
	catch (java.net.MalformedURLException exc) {
	    exc.printStackTrace();
	}
	return java.applet.Applet.newAudioClip(url);
    }   
}

class JouerSon extends JPanel implements java.awt.event.ActionListener {
    JButton jouer = new JButton("jouer");
    java.applet.AudioClip son;
    
    JouerSon() {
	son = Son.avoirSon("sons/oiseau.au");
	add(jouer);
	jouer.addActionListener(this);;
    } 
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
	son.play();
    }
    
    public static void main(String[] argv) {
	JFrame fenetre = new JFrame();
	fenetre.setContentPane(new JouerSon());
	fenetre.pack();
	fenetre.setVisible(true);
    }
}
