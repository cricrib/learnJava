import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ardoise extends JPanel {
	boolean lune = false;

	Ardoise() {
		final MenuContextuel menuContextuel = new MenuContextuel(this);
		setPreferredSize(new Dimension(200, 200));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					menuContextuel.show
(e.getComponent(),e.getX(), e.getY());
				}
			}
		});
	}

	public void paintComponent(Graphics g) {
		int largeur = getWidth();
		int hauteur = getHeight();

		super.paintComponent(g);
		g.fillOval(largeur/2 - 50, largeur/2 - 50, 100, 100);
		if (lune) {
			g.setColor(getBackground());
			g.fillOval(largeur/2-25, largeur/2-25, 100, 100);
		}
	}
}

// pour le menu déroulant
class MenuCouleur extends JMenu implements ActionListener{
	Ardoise ardoise;
	JMenuItem itemRouge = new JMenuItem("rouge");
	JMenuItem itemBleu = new JMenuItem("bleu");
	MenuCouleur(Ardoise _ardoise) {
		setText("couleur");
		ardoise = _ardoise;
		setMnemonic(KeyEvent.VK_C);

		itemRouge.setMnemonic(KeyEvent.VK_R);
		itemRouge.addActionListener(this);
		add(itemRouge);
	
		Action actionJaune =  new AbstractAction("jaune") {
			public void actionPerformed(ActionEvent evt) {
				ardoise.setForeground(Color.YELLOW);
				System.out.println(getValue(Action.NAME));
			}
		};
		actionJaune.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A); 
		add(actionJaune);
	
		itemBleu.setAccelerator(KeyStroke.getKeyStroke
(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		itemBleu.addActionListener(this);
		add(itemBleu);
	
		addSeparator();
	
		JMenu sousMenu = new JMenu("action");
		sousMenu.add(new JRadioButtonMenuItem("ne fait rien"));
		sousMenu.add(new JRadioButtonMenuItem("ne fait pas plus"));
		add(sousMenu);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == itemRouge) ardoise.setForeground(Color.RED);
		else if (source == itemBleu)
ardoise.setForeground(Color.BLUE);
	}
}

// pour le menu contextuel
class MenuContextuel extends JPopupMenu implements ItemListener {
	Ardoise ardoise;

	MenuContextuel(Ardoise _ardoise) { 
		ardoise = _ardoise;
		ButtonGroup groupeFormes = new ButtonGroup();
	
		JCheckBoxMenuItem itemBoite = new JCheckBoxMenuItem("soleil");
		itemBoite.addItemListener(this);
		groupeFormes.add(itemBoite);
		add(itemBoite);
	
		itemBoite = new JCheckBoxMenuItem("lune");
		itemBoite.addItemListener(this);
		groupeFormes.add(itemBoite);
		add(itemBoite);
	}

	public void itemStateChanged(ItemEvent e) {
		JMenuItem item = (JMenuItem)(e.getSource());
		String texte = item.getText();
	
		if (texte.equals("soleil")) ardoise.lune = false;
		else if (texte.equals("lune")) ardoise.lune = true;
		ardoise.repaint();
	}
}

class EssaiMenus extends JFrame {
	public static void main(String[] arg) {
		JFrame fenetre = new JFrame();
		Ardoise ardoise = new Ardoise();
		JMenuBar barreMenu = new JMenuBar();
	
		barreMenu.add(new MenuCouleur(ardoise));
		fenetre.setJMenuBar(barreMenu);

		fenetre.add(ardoise);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
