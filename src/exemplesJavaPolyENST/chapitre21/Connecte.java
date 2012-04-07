import java.io.*;
import java.net.*;

class Recepteur extends Thread  {
    Socket socket;
    
    Recepteur(Socket _socket)  {
	socket = _socket;
    }
    
    public void run(){
	try {
	    BufferedReader entree = new BufferedReader
		(new InputStreamReader(socket.getInputStream()));
	    while(true) {
		String texte = entree.readLine();
		if (texte == null) System.exit(0);
		System.out.println(texte);    
	    }
	}
	catch(IOException exc) {}
    }
}

class Emetteur extends Thread{
    Socket socket;
    
    Emetteur(Socket _socket)throws IOException {
	socket = _socket;
    }

    public void run(){
	try {
	    BufferedReader entree = new BufferedReader
		(new InputStreamReader(System.in));
	    PrintStream sortie = new PrintStream(socket.getOutputStream());
	    while(true) {
		String texte = entree.readLine();
		sortie.println(texte);    
	    }
	}
	catch(IOException exc) {}
    }
}


class Connecte {
    public static void main(String[] arg) throws IOException {
	int portEcouteServeur = 40302;
	Socket socket;

	try {
	    socket = new Socket(arg[0],portEcouteServeur);
	}
	catch(IOException exc) {
	ServerSocket  standardiste = new ServerSocket(portEcouteServeur);
	    socket = standardiste.accept();
	}
	(new Recepteur(socket)).start();
	(new Emetteur(socket)).start();
    }
}
