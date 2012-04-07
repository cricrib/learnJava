import java.io.*;
import javax.swing.JFileChooser;

class EssaiChoixFichier {
	public static void main(String[] arg) throws IOException {
		JFileChooser dialogue = new JFileChooser(".");
		PrintWriter ecrivain;
		File fichier;

		if (dialogue.showOpenDialog(null)==
 				JFileChooser.APPROVE_OPTION) {
			fichier = dialogue.getSelectedFile();
			ecrivain = new PrintWriter
				(new FileWriter (fichier.getPath(), true));
			ecrivain.println(arg[0]);
			ecrivain.close();
		}
		System.exit(0);
	}
}
