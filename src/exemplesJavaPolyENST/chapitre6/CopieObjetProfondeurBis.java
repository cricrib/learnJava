class EntierBis //implements Cloneable 
{
	int n = 2;

	protected Object clone()
		throws CloneNotSupportedException {
			return super.clone();
	}
}

class D implements Cloneable {
	int m = 1;
	EntierBis entier = new EntierBis();

	protected Object clone()
		throws CloneNotSupportedException {
		D d = (D)super.clone();
		d.entier = (EntierBis)entier.clone();
		return d;
	}
}

class CopieObjetProfondeurBis {
	public static void main(String arg[])
	throws CloneNotSupportedException {
		D objD = new D();
		D copieObjD;

		copieObjD = (D)objD.clone();
		copieObjD.m = 3;
		System.out.println("objD.m contient : " + objD.m);
		copieObjD.entier.n = 3;
		System.out.println("objD.entier.n contient : " +
 					objD.entier.n);
	}
}
