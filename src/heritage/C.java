package heritage;

/**
 * Quand on instancie une classe, on appelle nécessairement 
 * un constructeur de cette classe, ce qui fait que toute classe 
 * possède au moins un constructeur. 
 * un constructeur de sa superclasse (appelé par super(...)) ;
 * un autre constructeur de la même classe (appelé par this(...)).Cet appel est mis nécessairement 
 * en première ligne du constructeur.
 * En cas d'absence de cet appel, le compilateur ajoute super(); en première ligne du constructeur.
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
