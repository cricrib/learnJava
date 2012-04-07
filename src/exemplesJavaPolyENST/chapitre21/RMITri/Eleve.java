class Eleve implements Comparable, java.io.Serializable {
	int note;

	Eleve(int note) {
		this.note = note;
	}

	public int compareTo(Object autreEleve) {
		int autreNote = ((Eleve)autreEleve).note;
		if (note < autreNote) return -1;
		else if (note == autreNote) return 0;
		else return 1;
	}
}