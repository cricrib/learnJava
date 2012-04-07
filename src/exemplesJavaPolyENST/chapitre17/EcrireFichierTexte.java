import java.io.*;

class EcrireFichierTexte {
    public static void main(String[] arg) throws IOException {
	PrintWriter sortie;
	int n = 5;
	
	sortie = new PrintWriter(new FileWriter(arg[0]));
	
	sortie.print("On peut mettre des entiers : ");
	sortie.println(n);
	sortie.print("On peut mettre des instances de Object : ");
	sortie.println(new Integer(36));
	sortie.close();
    }
}
