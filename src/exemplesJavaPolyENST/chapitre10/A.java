	/** Classe inutile, juste <b>pour essayer</b>
	    @author 	anonyme
	    @version 	fevrier 2000
     */
    public class A {
		/** Donne le nombre d'instanciations */
		public static int nb;

		public A() {
			nb++;
		}

    	/** Pour faire un essai
    	 	@param 		c un caractère
    	 	@return 	la valeur entière de c
		 	@exception 	ClassCastException si bizarre
		    @see 		B
		  	@see		#faire(char c)
		  	@see		B#action()
    	*/
		public int faire(char c) throws  ClassCastException {
		if (c == 'a') throw new  ClassCastException();
		return (int)c;
	}
}
