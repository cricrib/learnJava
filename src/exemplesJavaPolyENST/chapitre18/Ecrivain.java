class Repetiteur extends Thread {
    String chaine;
    
    Repetiteur(String chaine) {
	this.chaine = chaine;
    }
    
    public void run() {
	System.out.print(chaine + " ");
	setPriority(Thread.MIN_PRIORITY);
	System.out.println(chaine);
    }
}

class Ecrivain {
    public static void main(String[] arg) {
	System.out.println("priorite actuelle : " +
			   Thread.currentThread().getPriority());
	System.out.println("priorite minimum : " + Thread.MIN_PRIORITY);
	System.out.println("priorite normale : " + Thread.NORM_PRIORITY);
	System.out.println("priorite maximum : " + Thread.MAX_PRIORITY);
	
	System.out.println("Nombre de threads : " + Thread.activeCount());
	Repetiteur r1 = new Repetiteur("soleil");
	System.out.println("Nombre de threads : " + Thread.activeCount());
	r1.start();
	Repetiteur r2 = new Repetiteur("neige");
	r2.start();
	Repetiteur r3 = new Repetiteur("ski");
	r3.start();
	System.out.println("A la montagne");
    }
}

