class C {
    void faire() {}
}

interface Operateur {
    int operer(int r);
}

class EssaiInternes {
    int n = 1, p;
    Operateur operateur;
    
    class A {
	A(int n) {
	    p = 1;
	    EssaiInternes.this.n = n;
	}
	
	void saluer() {
	    System.out.println("bonjour");
	}
    }
	
    void pourquoiPas() {
	class B  {
	    void rien() {}
	}
    }
    
    C c = new C () {
	    void faire() {
		System.out.println("on fait");
		defaire();
	    }
	    void defaire() { 
		System.out.println("on defait");
	    }
	};
    
    void embaucher(final int k) {
	operateur = new Operateur() {
		public int operer(int r) {
		    return r + k + n;
		}
	    };
    }
    
    public static void main(String[] arv) {
	EssaiInternes e = new EssaiInternes();
	e.embaucher(2);
	System.out.println(e.operateur.operer(3)); 
	e.c.faire();
	
	EssaiInternes.A a = e.new A(4); 
	System.out.println(e.n);
	a.saluer();
    }
}
