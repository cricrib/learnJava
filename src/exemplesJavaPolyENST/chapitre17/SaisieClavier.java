import java.io.*;
import java.util.StringTokenizer;

class SaisieClavier {
    public static void main (String[] arg) throws IOException,
	NumberFormatException {
	int somme = 0;
	String ligne;
	StringTokenizer st;
	BufferedReader entree = new BufferedReader
	    (new InputStreamReader(System.in));
	
	ligne = entree.readLine();
	while(ligne.length() > 0) {
	    st = new StringTokenizer(ligne);
	    while(st.hasMoreTokens())
		somme += Integer.parseInt(st.nextToken());
	    ligne = entree.readLine();
	}
	System.out.println("La somme vaut : " + somme);
	entree.close();
    }
}
