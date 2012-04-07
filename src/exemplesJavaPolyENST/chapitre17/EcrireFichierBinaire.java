import java.io.*;

class EcrireFichierBinaire {
	public static void main(String[] arg) throws IOException {
		DataOutputStream ecrivain;

		ecrivain = new DataOutputStream(new BufferedOutputStream
			(new FileOutputStream(arg[0])));

		ecrivain.writeUTF("Début");
		ecrivain.writeInt(765);
		ecrivain.writeLong(54321);
		ecrivain.writeFloat((float)2.35);
		ecrivain.writeDouble(1.8);
		ecrivain.writeChar('a');
		ecrivain.writeBoolean(false);
		ecrivain.writeChars("au revoir");
		System.out.println(ecrivain.size());
		ecrivain.close();
	}
}

