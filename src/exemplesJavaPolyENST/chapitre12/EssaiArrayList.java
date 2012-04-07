import java.util.ArrayList;

class EssaiArrayList {
	public static void main(String[] arg) {
		ArrayList<String> liste = new ArrayList<String>();
		
		liste.add("Sophie");
		liste.add("Marie");
		liste.add("Elsa");
		for (String s : liste) System.out.print(s + " ");
		System.out.println();
	}
}
