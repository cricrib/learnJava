class MonException extends Exception {
	MonException() {
		System.out.println("me voila");
	}
}

class Propagation {
	static void methode3() throws MonException {
		try {
			if (true) throw new MonException();
				System.out.println("et moi ?");
		}
		finally {
			System.out.println("niveau 3");
		}
		System.out.println("instruction inutile");
	}


	static void methode2() throws MonException {
		try {
			methode3();
			System.out.println("et ici ?");
		}
		finally {
			System.out.println("niveau 2");
		}
	}

	static void methode1() {
		try {
			methode2();
		}
		catch(MonException e) {
			System.out.println("exception attrapee...");
			e.printStackTrace();
		}
		System.out.println("reprise du cours normal");
	}

 static public void main(String[] arg) {
		methode1();
	}
}

me voila
niveau 3
niveau 2
exception attrapee...
MonException
        at Propagation.methode3(Propagation.java:10)
        at Propagation.methode2(Propagation.java:22)
        at Propagation.methode1(Propagation.java:32)
        at Propagation.main(Propagation.java:42)
reprise du cours normal
