class Entier {
    int n = 2;
}

class C {
    int m = 1;
    Entier entier = new Entier();
    
    C dupliquer() {
	C c = new C();
	c.m = m;
	c.entier = new Entier();
	c.entier.n = entier.n;
	return c;
    }
}

class CopieObjetProfondeur {
    public static void main(String arg[]) {
	C objC = new C();
	C copieObjC;
	
	copieObjC = objC.dupliquer();
	copieObjC.m = 3;
	System.out.println("objC.m contient : " + objC.m);
	copieObjC.entier.n = 3;
	System.out.println("objC.entier.n contient : " +
			   objC.entier.n);
    }
}
