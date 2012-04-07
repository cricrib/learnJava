class RepetiteurR implements Runnable {
    String chaine;
    
    RepetiteurR(String chaine) {
	this.chaine = chaine;
    }
    
    public void run() {
	System.out.print(chaine + " ");
	Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	System.out.println(chaine);
    }
}

class EcrivainR {
    public static void main(String[] arg) {
	Runnable repetiteur = new RepetiteurR("soleil");
	Thread thread = new Thread(repetiteur);
	thread.start();
	new Thread(new RepetiteurR("neige")).start();
	new Thread(new RepetiteurR("ski")).start();
	System.out.println("A la montagne");
    } 
}

