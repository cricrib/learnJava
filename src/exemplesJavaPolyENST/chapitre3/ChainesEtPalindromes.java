class ChainesEtPalindromes {
	String chaine;
	ChainesEtPalindromes(String s) {
		chaine = s;
	}

	String inverse() {
		StringBuilder envers = new StringBuilder(chaine);
		int longueur = chaine.length() ;;

		for (int i = 0; i < longueur; i++)
			envers.setCharAt(i, chaine.charAt(longueur - i - 1));
		return new String(envers);
	}

	boolean estPalindrome() {
		return chaine.equals(inverse());
	}
}

class EssaiPalindromes {
	public static void main(String[] arg) {
		String s = "irene";
		ChainesEtPalindromes cP = new ChainesEtPalindromes(s);
		System.out.println("Inverse de " + s + " : " + cP.inverse());
		System.out.println(s + " est un palindrome : " +
			cP.estPalindrome());
		s = "ressasser";
		System.out.println(s + " est un palindrome : "  +
			(new ChainesEtPalindromes(s)).estPalindrome());
	}
}
