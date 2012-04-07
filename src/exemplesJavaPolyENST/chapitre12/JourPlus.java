enum JourPlus 
{
    LUNDI(8), MARDI(8), MERCREDI(4), JEUDI(8), VENDREDI(7), 
    SAMEDI(0),  DIMANCHE(0);
    
    int nb_heures;
    
    JourPlus(int nb)
    {
	nb_heures = nb;
    }
    
    String action()
    {
	switch(this)
	    {
	    case SAMEDI : return "cinéma";
	    case DIMANCHE : return "dormir";
	    default : return "travailler";
	    }
    }
}

class EssaiJourPlus
{
    public static void main(String[] arg)
    {
	JourPlus jour = JourPlus.SAMEDI;
	System.out.println("numéro de " + jour + " : " +
			   jour.ordinal());
	System.out.println(jour + " : " + jour.action());
	
	for (JourPlus j : JourPlus.values())
		System.out.println("nombre d'heures de " +
				   j + " : " + j.nb_heures);
    }
}
