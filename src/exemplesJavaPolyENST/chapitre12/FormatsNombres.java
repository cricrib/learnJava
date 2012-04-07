class FormatsNombres {
    public static void main(String[] arg) {
	int degre = 28;
	System.out.printf("Il fait %d degrés\n", degre);
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++)
		System.out.printf("%7.3f", 1.0/(i + j + 1));
	    System.out.println();
	}	
	System.out.printf("%2$s  %1$s\n", "Charon", "Irène");    
	System.out.printf("Il est %1$tH h %1$tM mn et on a " +
			  "effectué %2$f %%\n", new java.util.Date(), 1.0/6); 
    }
}
    
/*
  1.000  0.500  0.333  0.250
  0.500  0.333  0.250  0.200
  0.333  0.250  0.200  0.167
  0.250  0.200  0.167  0.143
Il est 17 h 41 mn et on a effectué 0.166667 %

*/
