class Eleve implements Comparable {
	int note;

	Eleve(int _note) {
		note = _note;
	}

	public int compareTo(Object autreEleve) {
		int autreNote = ((Eleve)autreEleve).note;
		if (note < autreNote) return -1;
		else if (note == autreNote) return 0;
		else return 1;
	}
}
