import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ThreadDisque extends Thread {
    int r = 10;
    int debut;
    JComponent ardoise;
    boolean suspendu;
    boolean fini;
    
    ThreadDisque(JComponent ardoise) {
	debut = (int)System.currentTimeMillis();
	this.ardoise = ardoise;
    }
    
    synchronized void suspendre() {
	suspendu = true;
    }
    
    synchronized void reprendre() {
	suspendu = false;
	notify();
    }
    
    synchronized void stopper() {
	fini = true;
	notify();
    }
    
    public void run() {
	Graphics g = ardoise.getGraphics();
	int increment = 5 + (5 << 8) + (5 << 16);
	
	suspendu = false;
	fini = false ;
	int l = ardoise.getWidth();
	int h = ardoise.getHeight();
	ardoise.repaint();
	for (int i = 0; i < 60; i++) {
	    try {
		sleep(200);
		synchronized(this) {
		    while (suspendu && !fini) wait();
		}
	    }
	    catch(InterruptedException exc) {}
	    if (fini) break;
	    g.setColor(new Color(debut + increment*i));
	    g.drawOval(l/2 - r, h/2 - r, 2*r, 2*r);
	    r += 1;
	}
	g.dispose();
    }
}

class Disque extends JFrame implements ActionListener {
    ThreadDisque thread;
    JButton tracer = new JButton("tracer");
    JButton suspendre = new JButton("suspendre");
    JButton stopper = new JButton("stopper");
    JPanel ardoise = new JPanel();
    
    Disque() {
	JPanel boutons = new JPanel();
	boutons.add(tracer);
	boutons.add(suspendre);
	boutons.add(stopper);
	add(boutons, BorderLayout.NORTH);
	ardoise.setPreferredSize(new Dimension(150, 150));
	ardoise.setBackground(Color.WHITE);
	add(ardoise, BorderLayout.CENTER);
	
	tracer.addActionListener(this);
	suspendre.addActionListener(this);
	stopper.addActionListener(this);
	pack();
    }
    
    public void actionPerformed(ActionEvent evt) {
	Object source = evt.getSource();
	
	if (source == tracer) {
	    if ((thread == null)||(!thread.isAlive())) {
		thread = new ThreadDisque(ardoise);
		thread.start();
	    }
	    else thread.reprendre();
	}
	else if ((source == suspendre) && (thread != null))
	    thread.suspendre();
	else if (source == stopper) {
	    if (thread != null) thread.stopper();
	    thread = null;
	}
    }
    
    public static void main(String[] arg) {
	JFrame fenetre = new Disque();
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setLocation(100, 100);;
	fenetre.setVisible(true);
    }
}

