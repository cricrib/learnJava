import java.io.*;

class EssaiFileReader {
	public static void main(String[] arg) throws IOException {
		BufferedReader lecteur = null;
		String ligne;

		try {
			lecteur = new BufferedReader(new FileReader(arg[0]));
		}
		catch(FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
			System.exit(0);
		}
		while ((ligne = lecteur.readLine()) != null)
			System.out.println(ligne);
		lecteur.close();
	}
}
