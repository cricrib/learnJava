package animaux;

public class TestHerbivore {
	public static void main(String arg[]){
		Herbivore vache = new Herbivore(2, true);
		Mammifere vache2 = new Herbivore(4, false);
		System.out.println(vache.toString() + vache.laTaille() + vache.poids());
		//Impossible d'ex�cuter vache2.poids() car vache2 est de type Mammifere
		//Pour ex�cuter vache2.poids(), il faut transtyper vache2
		System.out.println(vache2.toString() + vache2.laTaille()/* + vache2.poids()*/);
		System.out.println(vache2.toString() + vache2.laTaille() + ((Herbivore)vache2).poids());
	}
/*Suppl�ment
 * 
 * De l�int�rieur d�une classe red�finissant une m�thode, 
 * on peut avoir acc�s � la m�thode red�finie de la superclasse, 
 * en utilisant le mot super.
 * 
 * class A
{
  void faire()
    {
      ...
    }
}

class B extends A
{
  void faire()
   {
	super.faire();
      	...
    }

  void pourquoiPas()
   { 	
      	...
      	super.faire();
      	...
	faire();

   }
}
 
 */
}
