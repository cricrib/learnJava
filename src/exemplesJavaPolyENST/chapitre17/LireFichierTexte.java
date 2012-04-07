import java.io.*;

class LireFichierTexte {
    public static void main(String[] arg) throws IOException  {
	BufferedReader lecteur;
	lecteur = new BufferedReader(new FileReader("essai.txt"));
	
	/*ou bien */	
	  InputStream entree =
	  LireFichierTexte.class.getResourceAsStream("essai.txt");
	  lecteur = new BufferedReader(new InputStreamReader(entree)); 
	*/
	String ligne;
	while ((ligne = lecteur.readLine()) != null)
	    System.out.println(ligne);
	lecteur.close();
    }
}
