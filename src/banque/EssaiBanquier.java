/**
 * 
 */
package banque;

/**
 * @author chris
 *
 */
class Compte
{
  int capital = 0;
  
  /*
   * Si on enl�ve synchronized alors le r�sultat imprim� sera 1 au lieu de 2
   */
  synchronized void credite(Banquier leBanquier, int deCombien) {
      int montant;
      System.out.println(leBanquier.nom + " commence son travail");
      montant = capital;
      Banquier.yield();
      System.out.println(leBanquier.nom + " continue son travail");
      capital = montant + deCombien;
    }
}


class Banquier extends Thread
{
  Compte unCompte;
  String nom;

  Banquier(Compte unCompte, String nom)
    {
      this.unCompte=unCompte;
      this.nom = nom;
    }

  @Override
   public void run()
    {
      System.out.println(nom+" est embauche");
      unCompte.credite(this,1);
    }
}

class EssaiBanquier
{
  public static void main(String[]Argv)
    {
      Compte unCompte = new Compte();
      Banquier Jean, Jacques;

      (Jean = new Banquier(unCompte, "Jean")).start();
      (Jacques = new Banquier(unCompte, "Jacques")).start();
      try
	{
	  Jean.join();
	  Jacques.join();
	}
      catch(InterruptedException e){}
      System.out.println("Votre capital est de " + unCompte.capital);
    }
}

/*
 * Si on ne veut pas synchronized sur le m�thode crediter alors on peut toujours 
 * poser un verrou sur l'instance de Compte trait�e ; le d�roulement 
 * est alors "quasi" identique � celui de l'exemple pr�c�dent. 
 * Le r�sultat final est bien 2.
 * 
 */ 
/*class Banquier2 extends Banquier
{
    Banquier2(Compte unCompte, String nom)
    {
      super(unCompte, nom);
    }

  public void run()
    {
      System.out.println(nom+" est embauche");
      synchronized(unCompte)
	{
	  unCompte.credite(this, 1);
	}
    }

}
 //*/
