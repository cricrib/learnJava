class A {}

class TypeDUnTableau {
    public static void main(String[] arg) throws Exception{
	int[] table1 = new int[2];
	Object[] table2 = new Object[2];
	
	System.out.print((table1 instanceof Object) + " ");
	System.out.print((table1 instanceof int[]) + " ");
	System.out.print((table2 instanceof Object) + " ");
	System.out.print((table2 instanceof Object[]) + " ");
	System.out.println(table2 instanceof A[]);
	}
}
