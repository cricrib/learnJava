import java.io.*;

class ClasseEssai implements Serializable {
	String chaine = "bonjour";
	int n = 1;
}

class Serialisation {
  public static void main(String[] arg) throws Exception {
		ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream("essai.dat"));
		sortie.writeObject(new ClasseEssai());
		sortie.writeObject(new java.util.Date());
		int[] tableau1 = {10, 11, 12};
		sortie.writeObject(tableau1);
		Integer[] tableau2 = {new Integer(110), new Integer(111)};
		sortie.writeObject(tableau2);
		sortie.close();

		ObjectInputStream entree = new ObjectInputStream(new FileInputStream("essai.dat"));

		ClasseEssai c = (ClasseEssai)entree.readObject();
		System.out.println(c.chaine);
		System.out.println(c.n);
		System.out.println(entree.readObject());
		int[] tableau3 = (int[])entree.readObject();
		System.out.println(tableau3[1]);
		Integer[] tableau4 = (Integer[])entree.readObject();
		System.out.println(tableau4[0]);
		entree.close();
	}
}