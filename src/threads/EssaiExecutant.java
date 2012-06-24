/**
 * 
 */
package threads;

/**
 * @author chris
 *
 */
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
class AfficheExecutant extends JPanel implements ActionListener
{
    JButton dessine = new JButton("dessine");
    JButton dessineS = new JButton("dessineS");
    JButton efface = new JButton("efface");
    Executant executant;
    ExecutantSynchro executantSynchro ;
    Thread thread1,thread2;
    JPanel panneauDessin = new JPanel();
    
    public AfficheExecutant()
    {
	executant = new Executant(panneauDessin);
	executantSynchro = new ExecutantSynchro(panneauDessin);
	dessine.addActionListener(this);
	dessineS.addActionListener(this);
	efface.addActionListener(this);

	JPanel panneauBouton = new JPanel();
	
	panneauBouton.add(dessine);
	panneauBouton.add(dessineS);
	panneauBouton.add(efface);
	setLayout(new BorderLayout(5, 5));
	add(panneauBouton, BorderLayout.NORTH);
	panneauDessin.setPreferredSize(new Dimension(300, 300));
	add(panneauDessin, BorderLayout.CENTER);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == dessine)
      {
	executant.initialiser();
	(new Thread(executant)).start();
	(new Thread(executant)).start();
	
      }
    else if (e.getSource() == dessineS)
      {
	executantSynchro.initialiser();
	(thread1 = new Thread(executantSynchro)).start();
	(thread2 = new Thread(executantSynchro)).start();
	//(new Thread(executantSynchro)).start();
      }
    else if (e.getSource()==efface)
      {
	repaint();
      }
  }
}
  
public class EssaiExecutant 
{
  public static void main(String[] argv)
  {
    JFrame fenetre = new JFrame();
    
    fenetre.setContentPane(new AfficheExecutant());
    fenetre.pack();
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setVisible(true);
  }
}
