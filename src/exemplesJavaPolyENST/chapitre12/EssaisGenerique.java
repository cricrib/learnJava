class EssaisGenerique 
{
    static <A> void ecrire(A a)
    {
	System.out.println(a);
    }

    static <T> void echangerGenerique(Couple<T> c)
    {
		T tampon;

	tampon = c.element1;
	c.element1 = c.element2;
	c.element2 = tampon;
    }
      
    static <A extends Comparable> void ordonnerGenerique(Couple<A> c)
    {
       if (c.element1.compareTo(c.element2) > 0)
	   echangerGenerique(c);
    }

    static void echangerAvecJoker(Couple<?> c)
    {
	echangerGenerique(c);
    }   

    static void ordonnerAvecJoker(Couple<? extends Comparable> c)
    {	
	if (c.element1.compareTo(c.element2) > 0)
	    echangerAvecJoker(c);
		/* Aussi possible :
		   if (c.element1.compareTo(c.element2) > 0)
		        echangerGenerique(c);
		   ou bien seulement :
		   ordonnerGenerique(c); */
    }

    static void extremes(Integer[] tab, Couple<? super Integer> minMax)
    {
	Integer min = Integer.MAX_VALUE,  max = Integer.MIN_VALUE;
	for(Integer elem : tab)
	    if (elem < min) min = elem;
	    if (elem  > max) max = elem;
	minMax.element1 = min;
	minMax.element2 = max;
    }

    public static void main(String[] arg)
    {
	ecrire(java.awt.Color.RED);

	Couple<String> mots = new Couple<String>("chapeau", "fleur");

	echangerGenerique(mots);
	System.out.println(mots);

	ordonnerGenerique(mots);	
	System.out.println(mots);

	echangerAvecJoker(mots);
	System.out.println(mots);

	ordonnerAvecJoker(mots);	
	System.out.println(mots);
	
	Integer[] table = {5, 3, 7};
	Couple<Object> mM = new Couple<Object>();	
	extremes(table, mM);
	System.out.println(mM);
    }
}
/*           
java.awt.Color[r=255,g=0,b=0] 
(fleur, chapeau) 
(chapeau, fleur)
(fleur, chapeau)
(chapeau, fleur)
8.799999952316284
(3, 7)

*/
