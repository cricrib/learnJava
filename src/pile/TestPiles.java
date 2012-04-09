package pile;

public class TestPiles {
	public static void main(String arg[]){
		Pile1 pile1 = new Pile1();
		Pile2 pile2 = new Pile2();
		Pile3 pile3 = new Pile3();
		if(arg.length > 0){ 
			for(int i = 0; i < arg.length - 1;i++){
				pile1.empiler(Integer.parseInt(arg[i]));
				pile2.empiler(Integer.parseInt(arg[i]));
				//try{
					pile3.empiler(Integer.parseInt(arg[i]));
				//}
				/*catch (ExceptionPilePleine e){
					System.out.println(e + "Ton tableau ne peut contenir que 10 elements");
				}*/
			}
		}
		System.out.println("Pile1: " + pile1.getListe());
		System.out.println("Pile2: " + pile2.getListe());
		System.out.println("Pile3: " + pile3.getListe());
		try {
			pile1.depiler();
			pile2.depiler();
			pile3.depiler();
		}
		catch (ExceptionPileVide e){
			System.out.println(e);
		}
		System.out.println("Pile1: " + pile1.getListe());
		System.out.println("Pile2: " + pile2.getListe());
		System.out.println("Pile3: " + pile3.getListe());
	}
}
