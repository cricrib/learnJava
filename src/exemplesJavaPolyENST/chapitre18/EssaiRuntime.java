import java.io.*;

class EssaiRuntime {
    public static void main(String[] arg) throws Exception {
	Runtime objetExecution = Runtime.getRuntime();
	
	System.out.println(objetExecution.totalMemory());
	
	Process sousProgramme;
	sousProgramme = objetExecution.exec("java Disque");
	sousProgramme.waitFor();
	
	System.out.println(objetExecution.freeMemory());
	objetExecution.gc();
	System.out.println(objetExecution.freeMemory());
	
	sousProgramme = objetExecution.exec("ls");
	InputStream i = sousProgramme.getInputStream();
	BufferedReader lecteur = 
	    new BufferedReader(new InputStreamReader(i));
	String ligne;
	while ((ligne = lecteur.readLine()) != null)
	    System.out.println(ligne);
    }
}

