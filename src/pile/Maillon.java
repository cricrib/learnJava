package pile;

public class Maillon {
	int donnee;
	Maillon suivant;
	Maillon(int donnee, Maillon suivant) {
		this.donnee = donnee;
		this.suivant = suivant;
	}

	int getDonnee() {
		return this.donnee;
	}
	
	void setDonnee(int n) {
		this.donnee = n;
	}
	
	Maillon getSuivant() {
		return this.suivant;
	}
	
	void setSuivant(Maillon n) {
		this.suivant = n;
	}
}
