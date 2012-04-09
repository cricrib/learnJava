package pile;

public class ExceptionPileVide extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int nbMots;
	ExceptionPileVide() //constructeur inutile ici mais je le laisse pour montrer qu'on peur l'avoir
  {
		@SuppressWarnings("unused")
		int nbMots = 0;
  }
  public String toString()  
  {
     return "ExceptionPileVide : la pile est vide!";
  }
}