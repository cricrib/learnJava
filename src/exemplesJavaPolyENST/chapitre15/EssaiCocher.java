import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ardoise extends JPanel {
	boolean faireMonde = false;
	boolean entourer = true;
	static final int PETIT = 10;
	static final int MOYEN = 50;
	static final int GRAND = 100;
	int rayon = PETIT;
	Image image;

	Ardoise() {
		image = getToolkit().getImage("../images/world.gif");
		setPreferredSize(new Dimension(250, 250));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int largeur = getWidth();
		int hauteur = getHeight();

		if (faireMonde) g.drawImage(image, largeur/2 - rayon,
hauteur/2 - rayon, 2*rayon, 2*rayon, this);
		else {
			g.setColor(Color.RED);
			g.fillOval(largeur/2 - rayon, 
hauteur/2 - rayon, 2*rayon, 2*rayon);
		}
		if (entourer) {
			g.setColor(Color.BLUE);
			BasicStroke epaississeur = new BasicStroke(10);
			((Graphics2D)g).setStroke(epaississeur);
				g.drawOval(largeur/2 - rayon - 5,
 hauteur/2 - rayon - 5, 2*rayon + 10, 2*rayon + 10);
		}
	}
}

class EssaiCocher extends JFrame implements ItemListener {
	Ardoise ardoise = new Ardoise();
	JRadioButton petit = new JRadioButton("petit", true);
	JRadioButton moyen = new JRadioButton("moyen", false);
	JRadioButton grand = new JRadioButton("grand", false);
	JCheckBox terre;
	JCheckBox tour = new JCheckBox("entoure", ardoise.entourer);
	ImageIcon icone;

	EssaiCocher() {
		setLayout(new FlowLayout());
		add(ardoise);
		JPanel panneauChoix = new JPanel(); // pour tous les boutons
		panneauChoix.setLayout(new BorderLayout(5, 5));
		panneauChoix.setBorder(BorderFactory.
createLoweredBevelBorder());

		// pour les boutons petit, moyen et grand
		JPanel panneauRadio = new JPanel();
		panneauRadio.setLayout(new GridLayout(3, 1));
		panneauRadio.setBorder
					(BorderFactory.createLineBorder(Color.GREEN)); 
		panneauRadio.add(petit);
		panneauRadio.add(moyen); 
		panneauRadio.add(grand); 
		panneauChoix.add(panneauRadio, BorderLayout.NORTH); 

		ButtonGroup groupe = new ButtonGroup();
		groupe.add(petit); 
		groupe.add(moyen);
		groupe.add(grand);

		// pour les boutons terre et entoure
		JPanel panneauCocher = new JPanel();
		panneauCocher.setLayout(new GridLayout(2, 1));
		panneauCocher.setBorder
(BorderFactory.createLineBorder(Color.RED));

		icone = new ImageIcon(ardoise.image.getScaledInstance
(10, 10, Image.SCALE_DEFAULT));
		terre = new JCheckBox("Terre", icone);
		panneauCocher.add(terre);
		tour.setSelected(true);
		panneauCocher.add(tour);
		panneauChoix.add(panneauCocher, BorderLayout.SOUTH); 

		add(panneauChoix); 

		petit.addItemListener(this);
		moyen.addItemListener(this);
		grand.addItemListener(this);
		terre.addItemListener(this);	
		tour.addItemListener(this);

		pack();
		setLocation(100, 100) ;
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent evt) {
		Object source = evt.getSource();

		if (source == petit) ardoise.rayon = Ardoise.PETIT;
		else if (source == moyen) ardoise.rayon = Ardoise.MOYEN;
		else if (source == grand) ardoise.rayon = Ardoise.GRAND;
		else if (source == tour) {
			if (evt.getStateChange() == ItemEvent.SELECTED)
				ardoise.entourer = true;
			else ardoise.entourer = false;
		}
		else if (source == terre) 
ardoise.faireMonde = !ardoise.faireMonde;
		ardoise.repaint() ;
	}

	public static void main(String[] arg) {
		JFrame fenetre = new EssaiCocher();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

