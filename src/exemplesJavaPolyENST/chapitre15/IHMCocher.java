import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ardoise extends JPanel {
	static final int PETIT = 10;
	static final int MOYEN = 50;
	static final int GRAND = 100;
	int rayon = PETIT;
	Image image;
	IHMCocher IHM;

	Ardoise(IHMCocher _IHM) {
		image = getToolkit().getImage("../images/world.gif");
		IHM = _IHM;
		setPreferredSize(new Dimension(250, 250));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (IHM.petit.isSelected()) rayon = PETIT;
		else if (IHM.moyen.isSelected()) rayon = MOYEN;
		else rayon = GRAND;
		if (IHM.terre.isSelected()) 
g.drawImage(image, 125 - rayon, 125 - rayon,
2*rayon, 2*rayon, this);
		else {
			g.setColor(Color.RED);
			g.fillOval(125 - rayon, 125 - rayon, 2*rayon, 2*rayon);
		}
	}
}

class IHMCocher extends JFrame {
	Ardoise ardoise = new Ardoise(this);
	JRadioButton petit = new JRadioButton("petit", true);
	JRadioButton moyen = new JRadioButton("moyen", false);
	JRadioButton grand = new JRadioButton("grand", false);
	JCheckBox terre = new JCheckBox("Terre");
	JButton boutonTrace = new JButton("tracer");

	IHMCocher() {
		setLayout(new BorderLayout(5, 5));
		add(ardoise, BorderLayout.CENTER);
	
		ButtonGroup groupe = new ButtonGroup();	
		groupe.add(petit);
		groupe.add(moyen);
		groupe.add(grand);

		JPanel panneauChoix = new JPanel();
		panneauChoix.setLayout(new GridLayout(4, 1));
		panneauChoix.add(petit);
		panneauChoix.add(moyen);
		panneauChoix.add(grand);
		panneauChoix.add(terre);
	
		JPanel panneau = new JPanel();
		panneau.add(panneauChoix);
		add(panneau, BorderLayout.EAST);

		boutonTrace.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					ardoise.repaint();
			}
		});
		add(boutonTrace, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] arg) {
		JFrame fenetre = new IHMCocher();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}
