class Constantes {
	final int CONST_INSTANCE;
	final static int CONST = 100;

	Constantes(int i) {
		CONST_INSTANCE = i;
		//CONST = i;			interdit
		//CONST_INSTANCE = 10;			interdit
	}
}

class EssaiConstantes {
	public static void main(String arg[]) {
		System.out.println((new Constantes(2)).CONST_INSTANCE);
		System.out.println(Constantes.CONST);
	}
}
