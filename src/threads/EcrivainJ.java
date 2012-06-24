package threads;

class EcrivainJ
{
  public static void main(String[] argv)
    {
      Repetiteur r1,r2,r3;

      r1 = new Repetiteur("soleil");
      r2 = new Repetiteur("neige");
      r3 = new Repetiteur("ski");
      r1.start();
      r2.start();
      r3.start();
      try //car join() throws InterruptedException
	{
    //mise en attente du thread en cours d'exécution jusqu'à ce que le thread r1 soit terminée
    //implique que "A la montagne" sera imprimé nécessairement après que r1 est fini
    r1.join();
	  //r2.join();
	  //r3.join();
	}
      catch(InterruptedException exc) {}
      System.out.println("A la montagne");
    } 
}

