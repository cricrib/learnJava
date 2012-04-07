class P {
    P ami;
    String nom;

    P(String _nom) {
	nom = _nom;
    }

    P(String _nom, P _ami) {
	nom = _nom;
	ami = _ami;
    }
}

class Amis {
    public static void main(String[] arg) {
	P antoine = new P("Antoine");
	P olivier =  new P("Olivier", antoine);
	antoine.ami = olivier;
	System.out.println("l'ami de " + antoine.nom + " est " + antoine.ami.nom);
    }
}
/*
l'ami de Antoine est Olivier
*/
