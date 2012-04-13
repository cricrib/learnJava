package heritage;

/**
 * Quand on instancie une classe, on appelle n�cessairement 
 * un constructeur de cette classe, ce qui fait que toute classe 
 * poss�de au moins un constructeur. 
 * un constructeur de sa superclasse (appel� par super(...)) ;
 * un autre constructeur de la m�me classe (appel� par this(...)).Cet appel est mis n�cessairement 
 * en premi�re ligne du constructeur.
 * En cas d'absence de cet appel, le compilateur ajoute super(); en premi�re ligne du constructeur.
 * 
 * @author chris
 *
 */
	class A {
	 	A() {
	     	System.out.println("constructeur de A");
	   }
	}


	class B extends A {
	  	B(){
	      System.out.println("constructeur de B");
	   }

	  B(int r) {
	      this(); // This est fucking important car il appelle le constructeur B()  
	      System.out.println("autre constructeur de B");
	   }
	}

public	class C extends B {
/*	  C() {
	    	super(3); 
		    System.out.println("constructeur de C");
	   }
*/
     C() { 
    	 System.out.println("bleu");
     }
	   
     public static void main(String argv[]) {
	      	new C();
	   }

	}
