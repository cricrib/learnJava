import javax.swing.*;

class JouerSon extends JFrame
							implements java.awt.event.ActionListener {
	JButton jouer = new JButton("jouer");
	java.applet.AudioClip son;

	JouerSon() {
		// Première possibilité
		java.net.URL url = JouerSon.class.getResource("sons/oiseau.au");
		son = java.applet.Applet.newAudioClip(url);

		/* Deuxième possibilité
		java.net.URL url = null; 
		try {	
	url = new java.net.URL("http://www.infres.enst.fr/"
+ "~charon/exemplesJava/chapitre20/sons/oiseau.au");
			} 
		catch (java.net.MalformedURLException exc) {
			exc.printStackTrace();
		}
		son = java.applet.Applet.newAudioClip(url); */

		add(jouer);
		jouer.addActionListener(this);;
		pack();
		setLocation(100, 100);
		setVisible(true);
	} 

	public void actionPerformed(java.awt.event.ActionEvent e) {
		son.play();
	}

	public static void main(String[] argv) {
		JFrame fenetre = new JouerSon();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

