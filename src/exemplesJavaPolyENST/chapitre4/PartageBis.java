class Outil {
    A a;
    
    Outil(A _a) {
	a = _a;
    }
    int calculerCarre() {
	return a.n * a.n;
    }
}

class A {
    int n = 3;
    
    A() {
	Outil outil = new Outil(this);
	System.out.println(outil.calculerCarre());
    }
}

class PartageBis {
    public static void main(String[] arg) {
	A a = new A();
    }
}

