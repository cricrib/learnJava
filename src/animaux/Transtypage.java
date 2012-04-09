package animaux;

	class Animal{}

	class Chien extends Animal 
	{
	  int taille = 80;
	}

	class Transtypage
	{
	  public static void main(String argv[])
	  {
		 Animal animal = new Chien();

		 System.out.println("un chien mesure : " + 
						((Chien)animal).taille + " cm");
		 animal = new Animal();
		 try
		 {
		 	@SuppressWarnings("unused")
			Chien chien = (Chien)animal;   //conversion de classe
		 }
		 catch (ClassCastException exc)
		 {
		   System.out.println(exc + ",tout Animal n'est pas un Chien");
		 }
	}
}
