class A {}

class B extends A {}

class EssaiInstanceof {
    public static void main(String[] arg) {
	Object obj = new A();	
	
	System.out.println("obj est une instance de A : "
			   + (obj instanceof A));	
	System.out.println("obj est une instance de Object : "
			   + (obj instanceof Object));
	System.out.println("obj est une instance de B : "
			   + (obj instanceof B));	
	System.out.println("obj est une instance de Integer : "
			   + (obj instanceof Integer));
    }
}
