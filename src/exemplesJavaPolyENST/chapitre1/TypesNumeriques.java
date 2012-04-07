class  TypesNumeriques {
	public static void main(String[] arg) {
		byte b;
		short s;
		int n;
		long l;
		float x ;
		double y = 100000000000.9;

		System.out.println("y : " + y);
		System.out.println("x : " + (x = (float)y));
		System.out.println("l : " + (l = (long)x));
		System.out.println("n : " + (n = (int)l));
		System.out.println("s : " + (s = (short)n));
		System.out.println("b : " + (b = (byte)(s/10)));
		System.out.println(y = x = l = n = s = b);
		System.out.println((int)4.98);
		System.out.println("byte : " + Byte.MIN_VALUE
			+ " ,  " + Byte.MAX_VALUE);
		System.out.println("short : " + Short.MIN_VALUE
			+ " ,  " + Short.MAX_VALUE);
		System.out.println("int : " + Integer.MIN_VALUE
			+ " ,  " + Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE
			+ " ,  " + Long.MAX_VALUE);
		System.out.println("float : " + Float.MIN_VALUE
			+ " ,  " + Float.MAX_VALUE);
		System.out.println("double : " + Double.MIN_VALUE
			+ " ,  " + Double.MAX_VALUE);
	}
}
