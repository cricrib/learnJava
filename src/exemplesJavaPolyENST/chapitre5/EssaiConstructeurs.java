class A {
	A() {
		System.out.println("constructeur de A");
	}
}
class B extends A {
	B() {
		System.out.println("constructeur de B");
	}

	B(int r) {
		this();			// appel au constructeur ci-dessus
		System.out.println("autre constructeur de B");
	}
}
class C extends B {
	C() {
		super(3);			// appel au constructeur ayant un
								// paramètre entier de la classe B
		System.out.println("constructeur de C");
	}

	public static void main(String[] arg) {
		new C();
	}
}
