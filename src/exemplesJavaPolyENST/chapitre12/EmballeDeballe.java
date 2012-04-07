class EmballeDeballe
{
    public static void main(String[] arg)
    {
	Integer n = 1;
	
	System.out.println(n instanceof Integer);
	n = n + 5;
	
	String s = n.toString();
	System.out.println(s);
    }
}
/*      
true
6
*/
