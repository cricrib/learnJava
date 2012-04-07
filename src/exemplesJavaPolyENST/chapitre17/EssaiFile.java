import java.io.*;

class EssaiFile {
	public static void main(String[] arg) throws IOException {
		File repertoire;
		File fichier = null;
		File nouveauFichier;
		String[] listeFichiers;
		PrintWriter ecrivain;

		repertoire = new File(arg[0]);
		if (!repertoire.isDirectory()) System.exit(0);
		fichier = new File(arg[0] + "/fichier.txt");

		System.out.println("Dans " + repertoire.getName() +
			", le fichier " + fichier.getName()+
				(fichier.exists() ? " existe" : " n'existe pas"));

		ecrivain = new PrintWriter(new FileOutputStream(fichier));
		ecrivain.println("bonjour");
		ecrivain.close();
		System.out.println("Le fichier " + fichier.getPath() +
 			(fichier.exists() ? " existe" : " n'existe pas"));
		System.out.println("Sa longueur est " + fichier.length());

		System.out.println("Son chemin complet est : "
			 + fichier.getAbsolutePath());
		System.out.println();
		listeFichiers = repertoire.list();
		for (int i = 0; i < listeFichiers.length; i++)
			System.out.println(listeFichiers[i]);
		System.out.println();

		String repertoireHome = System.getProperty("user.home");
		nouveauFichier = new File(repertoireHome + "/intrus.txt");
		fichier.renameTo(nouveauFichier);
		System.out.println("Le fichier " + fichier.getPath() +
			(fichier.exists() ? " existe" : " n'existe plus"));
		System.out.println("Le fichier " + nouveauFichier.getPath() +
			(nouveauFichier.exists() ? " existe" : " n'existe pas"));
		nouveauFichier.delete();
	}
}
