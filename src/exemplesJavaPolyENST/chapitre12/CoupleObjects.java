class CoupleObjects {
    Object element1, element2;

    CoupleObjects(Object elem1, Object elem2)  {
	element1 = elem1;
	element2 = elem2;
    }

    public static void main(String[] arg)   {	
	CoupleObjects c = new CoupleObjects("David", "33");
	String nom = (String)c.element1;
	Integer age = (Integer)c.element2;
    }
}
/*
Exception in thread "main" java.lang.ClassCastException: java.lang.String
        at CoupleObjects.main(CoupleObjects.java:12)

*/
