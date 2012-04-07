class Entier {
    int n;
    
    Entier(int i) {
	n = i;
    }
}

class EntierBis {
    int n;
    
    EntierBis(int i) {
	n = i;
    }
    
    public boolean equals(Object e) {
	return (e != null) &&  (e.getClass() ==  getClass())
	    && ((EntierBis)e).n == n;
    }
}

class TestEgalite {
    public static void main(String[] arg) {
	Entier e1 = new Entier(1);
	Entier e2 = new Entier(1);
	EntierBis eB1 = new EntierBis(2);
	EntierBis eB2 = new EntierBis(2);
	
	System.out.println(e1.equals(null));
	System.out.println("e1 et e2 sont egaux : "+(e1 == e2));
	System.out.println("e1 et e2 referencent des objets "+
			   "egaux : "+ e1.equals(e2));
	System.out.println("eB1 et eB2 sont égaux : "+ (eB1 == eB2));
	System.out.println("eB1 et eB2 referencent des objets "+
			   "egaux : "+ eB1.equals(eB2));
    }
}
