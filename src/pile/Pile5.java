package pile;

import java.util.Stack;

public class Pile5 {
	Stack<Integer> st = new Stack<Integer>(); 
	
	void pushInt(int cle){
		st.push(cle);
	}
	
	int popInt() throws ExceptionPileVide{
		if (st.isEmpty()) throw new ExceptionPileVide();
		return st.pop();
	}

	Stack<Integer> getListe(){
		return this.st;
	}
	
}
