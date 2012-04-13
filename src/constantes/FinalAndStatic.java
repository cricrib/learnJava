package constantes;

/**
 * 
 * Un attribut constant peut être défini en le munissant du modificateur final ; 
 * un attribut déclaré final ne peut 
 * être affecté qu'une seule fois, soit au moment de sa définition,
 * soit dans le constructeur de la classe.	
 * 
 * final static int MAX = 2; 
 * alors c'est un attribut de classe, donc indépendant de l'instance de la classe. 
 * C'est alors une constante de classe. 
 * 
 * @author chris
 *
 */

class Constantes {
  final int a = 10;
  final int b;
  static final int c = 100;
  Constantes(int b) {
      this.b = b;
  }
}

class FinalAndStatic {
  public static void main(String arg[]) {
      Constantes desConstantes = new Constantes(2);
    System.out.println("a = " + desConstantes.a + ", b = " + desConstantes.b + ", c = " + Constantes.c);
  }
}