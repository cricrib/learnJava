class ExceptionRien extends Exception {
    int nbChaines;
    ExceptionRien(int nombre) {
	nbChaines = nombre ;
    }
    
    public String toString() {
	return "ExceptionRien : aucune des " + nbChaines 
	    + " chaines n'est valide";
    }
}
