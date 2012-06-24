package initialisateur;

class TestInitialisateurStatique {
  static double[] desSinus = new double[10];

  static {//on peut aussi synchroniser un bloc d'instructions avec synchronized(){}
      for (int i = 0;i < desSinus.length; i++) 
                 desSinus[i] = Math.sin(i * Math.PI / 20);
    } 
}

class TestInitialiseurStatique {
  public static void main(String argv[]) {
    System.out.printf("%.5f\n", TestInitialisateurStatique.desSinus[1]);
  }
}

