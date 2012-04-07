class Animal {}

class Chat extends Animal 
{
    String nom;
    Chat(String _nom)
    {
	nom = _nom;
    }
}

class EssaisHeritage
{
    void faire()
    {
	Chat chat1 = new Chat("Tom"), chat2 = new Chat("Felix");
	Animal a;
	a = chat1;

	Couple<Chat> cC = new Couple<Chat>(chat1, chat2);
	
	Couple<Animal> cA;
	// cA = cC;

	Couple<? extends Animal> cB;	  
	cB = cC;

	Couple<?> cD;	  
	cD = cB;
    }
}

/*
EssaisHeritage.java:23: incompatible types
found   : Couple<Chat>
required: Couple<Animal>
        cA = cC;
             ^
1 error
*/
