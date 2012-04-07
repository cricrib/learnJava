class C {
    int n;
}

class A {
    C c = new C();
    
    A() {
	System.out.println("c dans A : " + c);
    }
}

class B {
    C c;
    
    B(C _c) {
	c = _c;
	System.out.println("c dans B : " + c);
    }
    
    void valuer(int x) {
	c.n = x;
    }
}

class Partage {
    public static void main(String[] arg) {
	A a = new A();
	B b =  new B(a.c);
	b.valuer(2);
	System.out.println(a.c.n);
    }
}
