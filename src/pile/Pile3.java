package pile;

public class Pile3 {
	private int[] tableau = new int[10];
	
	void empiler(int cle) /*throws ExceptionPilePleine*/{
	//	if(this.tableau[tableau.length - 1] == (Integer)null){
			this.tableau[tableau.length - 1] = cle;
		//}
		//else{
//			throw new ExceptionPilePleine();
	//	}
	}
	
	int depiler() throws ExceptionPileVide{
		if(tableau.length == 0){
			throw new ExceptionPileVide();
		}
		int cle = this.tableau[tableau.length - 1];
		this.tableau[tableau.length - 1] = (Integer) null;
		return cle;
	}
	
	int[] getListe(){
		return this.tableau;
	}

}
