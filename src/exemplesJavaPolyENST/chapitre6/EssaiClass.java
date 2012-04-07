class A {}

class B extends A {}

class EssaiClass {
    public static void main(String[] arg) throws
	ClassNotFoundException, IllegalAccessException,
	InstantiationException {
	Object obj;
	Class classe ;
	
	classe = Class.forName(arg[0]);
	obj = classe.newInstance();
	System.out.println("classe de obj : " + obj.getClass());
	classe = A.class;
	System.out.println("obj est une instance de A : " +
			   classe.isInstance(obj));
    }
}
