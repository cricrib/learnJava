import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.jnlp.*;


class Identite implements Serializable
{
    String nom, prenom;

    Identite(String _nom, String _prenom) {
	nom = _nom;
	prenom = _prenom;
    }

    public static void main(String[] arg){
	JFrame fenetre = new JFrame("identite");
	fenetre.setContentPane(new Panneau());
	fenetre.pack();
	fenetre.setVisible(true);
    }
}

class Panneau extends JPanel implements ActionListener{
    JButton ouverture = new JButton("charger");
    JButton sauvegarde = new JButton("sauvegarder");
    JTextField nom = new JTextField(10);
    JTextField prenom = new JTextField(10);

    Panneau() {
	setLayout(new GridLayout(3,2));
	add(ouverture);
	add(sauvegarde);
	add(new JLabel("nom :"));
	add(nom);
	add(new JLabel("prenom :"));
	add(prenom);
	ouverture.addActionListener(this);
	sauvegarde.addActionListener(this);
    }

    void ouvrir() {
	try {
	    FileOpenService ouverture = (FileOpenService)ServiceManager.lookup
		("javax.jnlp.FileOpenService");
	    FileContents contenu = ouverture.openFileDialog(".", new String[]{"txt"});
	    InputStream entreeOctets = contenu.getInputStream();
	    ObjectInputStream entree = new ObjectInputStream(entreeOctets);
	    Identite identite = (Identite)entree.readObject();
	    nom.setText(identite.nom);
	    prenom.setText(identite.prenom);
	}
	catch (Exception exc) {
	    // exc.printStackTrace();
	    JOptionPane.showMessageDialog(null, exc);
	}
    }
    
    void sauvegarder()
    {
	try {
	    Identite identite = new Identite(nom.getText(), prenom.getText());
	    ByteArrayOutputStream sortieOctets = new ByteArrayOutputStream();
	    ObjectOutputStream sortie = new ObjectOutputStream(sortieOctets);
	    sortie.writeObject(identite);
	    InputStream entree = new ByteArrayInputStream
		(sortieOctets.toByteArray());
	    FileSaveService sauve = 
		(FileSaveService)ServiceManager.lookup
		("javax.jnlp.FileSaveService");
	    sauve.saveFileDialog(".", new String[]{}, entree, "identite.txt");
	}
	catch (Exception exc) {
	    //exc.printStackTrace();
	    JOptionPane.showMessageDialog(null, exc);
	}
    }

    public void actionPerformed(ActionEvent evt){
	Object source = evt.getSource();
	if (source.equals(ouverture)) ouvrir();
	    else if (source.equals(sauvegarde)) sauvegarder();
    }
    
}


//javac  -classpath /usr/local/jdk1.5.0/jre/lib/javaws.jar:. Identite.java
