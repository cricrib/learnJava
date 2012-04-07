import java.util.*;

class EssaiFor
{
	public static void main(String[] arg)
	{
		double[] T = {3.2, 5.7, 7.0};
		double somme = 0;
		for (double d : T) somme += d;
		System.out.println(somme);

		Vector<String> vecteur = new Vector<String>();
		vecteur.add("bonjour");
		vecteur.add("langage");
		vecteur.add("java");
		for (String s : vecteur) System.out.print(s + " ");
		System.out.println();
	}
}
