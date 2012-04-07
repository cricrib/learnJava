class A {
    static int num;
	static void faire() {
		System.out.print(++num + " : A  ");
	}
	static void defaire() {}
}

class B extends A {
	static void faire() {
		System.out.print(++num + " : B  ");
	}

	// void defaire() {}		erreur a la compilation

    public static void main(String[] arg) {
	A.faire(); // 1
	B.faire(); // 2
	A a = new A();
	a.faire(); // 3
	B b = new B();
	b.faire(); // 4
	a = new B();
	a.faire(); // 5				// ce cas demande plus d'attention
	(new B()).faire(); // 6
	((A)new B()).faire(); // 7
	System.out.println();
    }
}
