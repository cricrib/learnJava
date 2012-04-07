class A {
    void faire() {
	System.out.println("fait de A");
    }
}
class B extends A {
    void faire() {
	super.faire();
	System.out.println("fait de B");
    }
    
    void pourquoiPas() {
	super.faire();
	faire();
    }
    
    public static void main(String[] arg) {
	(new B()).pourquoiPas();
    }
}
