class Fenetre {
    public static void main(String[] arg) {
	 java.awt.Toolkit boiteAOutil = 
	     java.awt.Toolkit.getDefaultToolkit();
	java.awt.Dimension dim = boiteAOutil.getScreenSize();
	int largeurEcran = dim.width;
	int hauteurEcran = dim.height;
	int largeurFenetre = largeurEcran/5;
	int hauteurFenetre = hauteurEcran/4;

	javax.swing.JFrame cadre = new javax.swing.JFrame("Vide");
	cadre.setSize(largeurFenetre, hauteurFenetre);
	cadre.setLocation((largeurEcran - largeurFenetre)/2,
			  (hauteurEcran - hauteurFenetre)/2);
	cadre.setVisible(true);
    }
}

