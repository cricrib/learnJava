class Animal { }

class Chien extends Animal {
	int taille = 80;
}

class Conversion {
	public static void main(String arg[]) {
		Chien chien;
		Animal animal = new Chien();

		chien = (Chien)animal;		//conversion de classe
		System.out.println("un chien mesure : " + chien.taille + " cm");
		animal = new Animal();
		try {
			chien = (Chien)animal;		//conversion de classe
		}
		catch (ClassCastException exc) {
			System.out.println(exc + ", tout Animal n'est pas un Chien");
		}
	}
}
