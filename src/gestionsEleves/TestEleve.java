package gestionsEleves;

public class TestEleve {
  
  public static void main(String arg[]) {
    Eleve student = new Eleve(arg[0]);
	for(int i = 1; i < arg.length; i++) {
	    //System.out.println(student.getMoyenne());
		student.ajouterNote(Integer.parseInt(arg[i]));
	}
	System.out.println(student);
  }
}
