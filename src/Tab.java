public class Tab {
  public static void main(String[] arg){
  	int somme = 0;
  	for(String chaine: arg) somme += Integer.parseInt(chaine) ;
  	System.out.println(somme);
  }
}
