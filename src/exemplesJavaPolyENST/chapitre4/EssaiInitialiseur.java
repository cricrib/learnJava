class EssaiInitialiseur {
    int a;
    int b = 1, c;
    NouveauPoint point1 = new NouveauPoint(1, 2), point2;
    
    EssaiInitialiseur (int abscisse) {
	a = abscisse;
	point2 = new NouveauPoint(a, b);
    }
}
