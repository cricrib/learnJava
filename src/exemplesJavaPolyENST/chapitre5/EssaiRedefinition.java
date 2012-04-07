class A {
	void faire() {
		System.out.println("niveau a");
	}
}

class B extends A {
	void faire() {
		System.out.println("niveau b");
	}
}

class C extends B {
	public static void main(String[] arg) {
		A a = new A();

		a.faire();
		a = new B();	// 1
		a.faire();
		a = new C(); 
		a.faire();	// 2
	}
}
