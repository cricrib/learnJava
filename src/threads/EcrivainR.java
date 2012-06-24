package threads;
/**
 * Cette exemple montre l'intérêt d'implémenter l'interface Runnable 
 * au lieu d'hériter de la classe Thread. On peut ainsi définir la méthode run() à notre guise
 * (la classe Thread implements Runnable) 
 *
 */
class RepetiteurR implements Runnable
{
  String chaine;

  RepetiteurR(String chaine)
    {
      this.chaine = chaine;
    }
  
  @Override
  public void run()
    {
       System.out.println(chaine);
       Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
       System.out.println(chaine);
    }
}

class EcrivainR 
{
  public static void main(String[] argv)
    {
      Thread monThread = new Thread(new RepetiteurR("hello"));
      monThread.start(); //méthode start de la classe Thread
  	  new Thread(new RepetiteurR("soleil")).start();
      new Thread(new RepetiteurR("neige")).start();
      new Thread(new RepetiteurR("ski")).start();
      System.out.println("A la montagne");
    } 
}