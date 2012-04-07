import java.io.*;

class LireFichierBinaire {
    public static void main(String[] arg) throws IOException {
	DataInputStream lecteur;	

	lecteur = new DataInputStream(new FileInputStream(arg[0]));
	System.out.println(lecteur.readUTF());
	System.out.println(lecteur.readInt());
	System.out.println(lecteur.readLong());
	System.out.println(lecteur.readFloat());
	System.out.println(lecteur.readDouble());
	System.out.println(lecteur.readChar());
	System.out.println(lecteur.readBoolean());
	while (lecteur.available() > 0)
	    System.out.print(lecteur.readChar());
	System.out.println();
	lecteur.close();
    }
}
