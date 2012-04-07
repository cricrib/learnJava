class Mammifere {
    int taille;
    
    Mammifere(int taille) {
	this.taille = taille;
    }
    
    public String toString() {
	return "animal à sang chaud mesurant " + taille + " cm";
    }
}

class Herbivore extends Mammifere {
    boolean ruminant;
    Herbivore(int taille, boolean ruminant) {
	super(taille);
	this.ruminant = ruminant;
    }
    
    public String toString() {
	if (ruminant) return super.toString()
			  + " qui mange des vegetaux et rumine.";
	else return super.toString()
		 + " qui mange des vegetaux et ne rumine pas.";
    }
}

class EssaiHerbivore {
    public static void main(String[] arg) {
	Mammifere chat = new Mammifere(40);
	Herbivore vache = new Herbivore(200, true);

	System.out.println(chat) ;
	System.out.println("Marguerite : "  +  vache);
    }
}
