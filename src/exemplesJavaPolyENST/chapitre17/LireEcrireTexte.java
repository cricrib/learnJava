import java.io.*;

class LireEcrireTexte {
    public static void main(String[] arg) throws IOException {
	String fichierLecture = arg[0];
	FileReader entree = new FileReader(fichierLecture);
	FileWriter sortie = new FileWriter("copie" + fichierLecture);
	int c;
	
	sortie.write("copie de " + fichierLecture + '\n');
	while((c = entree.read()) != -1) sortie.write(c);
	entree.close();
	sortie.close();
    }
}
