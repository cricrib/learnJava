class Eleve implements Comparable<Eleve> {
	int note;

	Eleve(int _note) {
		note = _note;
	}

	public int compareTo(Eleve autreEleve) {
		int autreNote = autreEleve.note;
		if (note < autreNote) return -1;
		else if (note == autreNote) return 0;
		else return 1;
	}
}
