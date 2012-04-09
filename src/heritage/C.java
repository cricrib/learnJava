package heritage;

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
