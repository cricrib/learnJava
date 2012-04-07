// La classe de base de ces types est java.lang.Enum ; y voir les méthodes dont dispose Jour

enum Jour 
{
    //d'abord
    LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE; 
}

class EssaiJour
{
    public static void main(String[] arg)
    {
	Jour jour = Jour.valueOf(arg[0]);
	//idem à Jour jour = Enum.valueOf(Jour.class, arg[0]);
	if (jour == Jour.SAMEDI) System.out.print("fin de semaine : ");
	switch(jour)
	    {
	    case SAMEDI :
	    case DIMANCHE :
		System.out.println("se reposer");
		break;
	    default : 
		System.out.println("travailler");
		break;
	    }
    }
}
