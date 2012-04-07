class CompareChaine {
	public static void main(String[] arg) {
		String r = "essai";
		String s = "es" + "sai";
		String t = "essais";
		String u = "ESSAI".toLowerCase();

		System.out.println("r identique avec t : " + (r == t));
		System.out.println("r identique avec s : " + (r == s));
		System.out.println("r identique avec u : " + (r == u));
		System.out.println("r.equals(u) = " + r.equals(u));
		System.out.println("r.compareTo(u) = " + r.compareTo(u));
		System.out.println("r.compareTo(t) = " + r.compareTo(t));
		System.out.println("t.compareTo(r) = " + t.compareTo(r));
	}
}
