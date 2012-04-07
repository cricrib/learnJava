import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ConteneurInternes extends JPanel {
	ConteneurInternes() {
		setLayout(new BorderLayout(5, 5));
		final JLabel etiquette = new JLabel();

		JPanel lesBoutons = new JPanel();
		final JButton bouton1 = new JButton("bouton1");
		final JButton bouton2 = new JButton("bouton2");

		lesBoutons.add(bouton1);
		class EcouteBouton1 implements ActionListener {
			EcouteBouton1() {
				etiquette.setText(etiquette.getText() + " ecoute1");
			}

			public void actionPerformed(ActionEvent e) {
				etiquette.setText(this.toString());
			}

			public String toString() {
				return "instance de EcouteBouton1";
			}
		}
		bouton1.addActionListener(new EcouteBouton1());

		lesBoutons.add(bouton2);

		ActionListener ecouteur  = new ActionListener() { {
				etiquette.setText(etiquette.getText() + " ecoute2");
		}

			public void actionPerformed(ActionEvent e) {
				etiquette.setText(ConteneurInternes.this.toString());
			}
		};
		bouton2.addActionListener(ecouteur);

		add(lesBoutons, BorderLayout.NORTH);
		add(etiquette, BorderLayout.SOUTH);
	}

	public String toString() {
		return "instance de ConteneurInternes";
	}
}

class Internes {
	public static void main(String[] arg) {
		JFrame cadre = new JFrame();
		cadre.setContentPane(new ConteneurInternes());
		cadre.pack();
		cadre.setVisible(true);
	}
}
