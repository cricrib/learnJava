package threads;

import java.util.Random;

class Joueur extends Thread
{
  Random alea; 
  int resultat;
  String nom;
  boolean tiragefait = false;
  boolean fini = false;
  Joueur adversaire;
  
  Joueur(Random alea, String nom)
    {
      this.alea=alea;
      this.nom=nom;
    }

  public void run()
    {
      try
	  {
	     sleep(Math.abs(alea.nextInt())%1000);
	     resultat = Math.abs(alea.nextInt())%10000;
	     tiragefait = true;
	     synchronized(this)
	     {
	        notify();
	     }
	     synchronized(adversaire)
	     {
	        while (!adversaire.tiragefait) adversaire.wait();
	     }
	     String phrase = (resultat >= adversaire.resultat ?
                        ", j'ai gagné" : ", j'ai perdu");  
	     System.out.println(nom + " : " + resultat + phrase) ;
	     sleep(Math.abs(alea.nextInt()) % 1000);
	     fini = true;
	     synchronized(adversaire) 
             {
		while (!adversaire.fini) adversaire.wait();
	     }
         }
       catch(InterruptedException exc) {}
       System.out.println(nom + " vous dit au revoir");
    }
}

class Jeu
{
  public static void main(String[] argv)
    {
      Random alea = new Random();
     
      Joueur David = new Joueur(alea, "David");
      Joueur Antoine = new Joueur(alea, "Antoine");
      Antoine.adversaire = David;
      David.adversaire = Antoine;
      David.start();
      Antoine.start();
    }
}