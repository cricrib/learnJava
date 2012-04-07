import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


class Disque extends JPanel implements ActionListener {
	JButton tracer = new JButton("tracer");
	JButton suspendre = new JButton("suspendre");
	JButton stopper = new JButton("stopper");
	JButton effacer = new JButton("effacer");
	JPanel ardoise = new JPanel();
	Timer timer;
	int debut = (int)System.currentTimeMillis()*777;
	int r = 10;

	Disque() {
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		JPanel boutons = new JPanel();
		boutons.add(tracer);
		boutons.add(suspendre);
		boutons.add(stopper);
		boutons.add(effacer);
		setLayout(new BorderLayout());
		add(boutons, BorderLayout.NORTH);
		ardoise.setPreferredSize(new Dimension(150, 150));
		add(ardoise, BorderLayout.CENTER);
		tracer.addActionListener(this);
		suspendre.addActionListener(this);
		stopper.addActionListener(this);
		effacer.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == tracer) {
			if (timer == null) timer = new Timer(200, this);
			timer.start();
		}

		else if (source == suspendre)
			timer.stop();

		else if (source == stopper) {
			timer.stop();
			r = 10;
			debut = (int)System.currentTimeMillis()*777;
		}

		else if (source == effacer) ardoise.repaint();
		else if (source == timer) {
			Graphics g = ardoise.getGraphics();
			g.setColor(new Color((debut + 264212*r) % Integer.MAX_VALUE));
			int l = ardoise.getWidth();
			int h = ardoise.getHeight();
			g.drawOval(l/2 - r, h/2 - r, 2 * r, 2 * r);
			g.dispose();
			r += 2;
			if (r == 70) {
				timer.stop();
				r = 10;
			}
		}

	}

	public static void main(String[] arg) {
		JFrame f = new JFrame();
		f.setContentPane(new Disque());
		f.pack() ;
		f.setVisible(true);
	}
}
