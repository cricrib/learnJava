package geometrie;

class Carre {
	int cote;
	Carre(int cote){
		this.cote = cote;
	}
	
	int perimetre(){
		int perim = cote * cote;
		return perim;
	}
}
