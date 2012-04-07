class EssaiThis 
{
    void faire(EssaiThis instance) 
{
    System.out.println(instance == this);
}

    public static void main(String[] arg) throws Exception
    {
	EssaiThis instance1 = new EssaiThis();
	EssaiThis instance2 = new EssaiThis();
	instance1.faire(instance2);
	instance1.faire(instance1);
    }
}
