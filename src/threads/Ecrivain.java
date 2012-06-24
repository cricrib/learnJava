package threads;

class Repetiteur extends Thread
{
  String chaine;

  Repetiteur(String chaine)
    {
      this.chaine=chaine;
    }
  
  @Override
  public void run()
    {
	System.out.println(chaine);
	// pas besoin de Thread.currentThread().setPriority(Thread.MIN_PRIORITY); puisqu'on hérite de Thread
	setPriority(Thread.MIN_PRIORITY);
	System.out.println(chaine);
    }
}


class Ecrivain {
	public static void main(String[] argv)
  {
    System.out.println("priorite actuelle : "+
	 	 Thread.currentThread().getPriority());
    System.out.println("priorite minimum : "+
		 Thread.MIN_PRIORITY);
    System.out.println("priorite normale : "+
		 Thread.NORM_PRIORITY);
    System.out.println("priorite maximum : "+
		 Thread.MAX_PRIORITY);

    System.out.println("Nombre de threads : " + Thread.activeCount());
    //les trois threads qui suivent vont tourner en parallele avec le thread main,   
    //au moins de maniere simulee      
    Repetiteur r1 = new Repetiteur("soleil");
    r1.start();
    System.out.println("Nombre de threads : " + Thread.activeCount());
    Repetiteur r2 = new Repetiteur("neige");
    r2.start();
    Repetiteur r3 = new Repetiteur("ski");
    r3.start();
    System.out.println("Nombre de threads : " + Thread.activeCount());
    System.out.println("A la montagne");
  } 
}
