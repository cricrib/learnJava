import java.io.*;

class EssaiStream {
	public static void main (String[] arg) throws IOException {
		int somme = 0;
		int type;

		StreamTokenizer entree = new StreamTokenizer
			(new InputStreamReader(System.in));

		System.out.println("Donnez vos entiers");
		type = entree.nextToken();
		while(type == StreamTokenizer.TT_NUMBER) {
			somme += (int)entree.nval;
			type = entree.nextToken();
		}
		System.out.println("La somme vaut : " + somme);
	}
}
