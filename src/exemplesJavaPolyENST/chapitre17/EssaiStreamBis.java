import java.io.*;

class EssaiStreamBis {
	public static void main (String[] arg) throws IOException {
		int somme = 0;
		FileReader fichier = new FileReader(arg[0]);

		StreamTokenizer entree = new StreamTokenizer(fichier);
		while(entree.nextToken() == StreamTokenizer.TT_NUMBER) {
			somme += (int)entree.nval;
		}
		System.out.println("La somme vaut : " + somme);
		fichier.close();
	}
}
