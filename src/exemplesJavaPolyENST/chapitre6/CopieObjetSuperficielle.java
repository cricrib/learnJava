class Entier {
	int n = 2;
}

class B implements Cloneable {
	int m = 1;
	Entier entier = new Entier();

	protected Object clone() throws CloneNotSupportedException {
		return super.clone() ;
	}

}

class CopieObjetSuperficielle {
	public static void main(String arg[])
			throws CloneNotSupportedException {
		B objB = new B();
		B copieObjB;

		copieObjB = (B)objB.clone();
		copieObjB.m = 3;
		System.out.println("objB.m contient : " + objB.m);
		copieObjB.entier.n = 3;
		System.out.println("objB.entier.n contient : " +
 			objB.entier.n);
	}
}