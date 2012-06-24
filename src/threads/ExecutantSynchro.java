package threads;

/**
 * @author chris
 *
 */
public class ExecutantSynchro extends Executant
{
  public ExecutantSynchro(javax.swing.JPanel panneau)
  {
    super(panneau);
  }

  synchronized public void run()
  {
    super.run();
  }
}
