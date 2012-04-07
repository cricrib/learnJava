class Couple <A> {
    A element1, element2;
    
    Couple(){};
    Couple(A elem1, A elem2) {
	element1 = elem1;
	element2 = elem2;
    }

    public String toString() {
	return "(" + element1 + ", " + element2 + ")";
    }
}

class EssaiCouple {
    public static void main(String[] arg) {
	Couple<String> c;
	
	c = new Couple<String>("David", "Irene");
	String nom = c.element1;
	Integer age = c.element2;
    }
}


/*
Couple.java:16: incompatible types
found   : java.lang.String
required: java.lang.Integer
        Integer age = c.element2;
                       ^
1 error
 */
