import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;

class Tableur extends JFrame implements TableModelListener {
	TableModel tableur;

	Tableur() {
		Object[][] donnees = {{"Eleve 1", "", "", ""},
{"Eleve 2", "", "", ""}, {"Eleve 3", "", "", ""}}; 
		String[] nomsColonnes = {"Nom", "Note 1", "Note 2", "Moyenne"};
		JTable table = new JTable(donnees, nomsColonnes);
		table.setPreferredScrollableViewportSize
(new Dimension(300, 50));
		add(new JScrollPane(table));
		tableur = table.getModel();
		tableur.addTableModelListener(this);
		pack(); 
	}

	public void tableChanged(TableModelEvent e) {
		if (e.getType() != TableModelEvent.UPDATE) return;
		int ligne = e.getFirstRow();
		int colonne = e.getColumn();
		int i, somme = 0, nb = 0;
		String chaine;

		if ((colonne > 0) && (colonne < 3)) {
			for (i = 1; i < 3; i++) {
				try {
					chaine = (String)tableur.getValueAt(ligne, i);
					somme += Integer.parseInt(chaine);
					nb++;
				}
				catch(NumberFormatException exc) {}
			}
			if (nb > 0) 
				tableur.setValueAt(new Integer(somme/nb), ligne, 3);
			else tableur.setValueAt("", ligne, 3);
		}
	}

	public static void main(String[] arg) {
		JFrame fenetre = new Tableur(); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(100, 100) ;
		fenetre.setVisible(true); 
	}
}

