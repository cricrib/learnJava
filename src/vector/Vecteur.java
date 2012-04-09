package vector;

import java.util.Random;
import java.util.Vector;

public class Vecteur {
	
	Vecteur(){
		
	}
	
	@SuppressWarnings("unchecked")
	static void emplit(@SuppressWarnings("rawtypes") Vector vecteur){
		Random  alea = new Random();
		for (int i = 0; i < 10; i++) 
			vecteur.addElement (new Integer(Math.abs(alea.nextInt()) % 100));
	}
	
	class A 
	{
	  int i;
	  A(int i) 
	   { 
	      this.i = i;
	   }
	}

	class B extends A {
		B(){
			super(5);
		}
	}
		
	public static void main(String arg[]){
		@SuppressWarnings("unused")
		Vecteur vecteur = new Vecteur();				
	}
}
