import java.io.*;

class Cahier {
	PrintWriter scribe;

	Cahier(String nom) {
		try {
			scribe = new PrintWriter(new FileWriter(nom));
		}
		catch (IOException exc) {
			System.out.println("Probleme d'ouverture de fichier");
			System.exit(1);
		}
	}

	protected void finalize() {
		if (scribe != null) scribe.close();
	}
}

class EssaiFinaliseur {
	public static void main(String[] arg) {
	    String nomFichier = javax.swing.JOptionPane.showInputDialog
		("donnez le nom du fichier");
	    Cahier ouvrage = new Cahier(nomFichier);
	    ouvrage.scribe.println("bonjour");
	    ouvrage.scribe.close();
	}
}
