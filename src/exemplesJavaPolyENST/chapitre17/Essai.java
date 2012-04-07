import java.io.*;

	class Essai {
	public static void main(String[] arg) throws IOException {
		String chaine = "bonjour\nsalut";
		BufferedReader lecteur = new BufferedReader(new StringReader(chaine));

		String ligne;
		while ((ligne = lecteur.readLine()) != null)
			System.out.println(ligne);
		lecteur.close();
	}
}