import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServeurTri extends UnicastRemoteObject implements Trieur {
	public ServeurTri() throws RemoteException {}

	public Comparable[] trier(Comparable[] tableau) {
		System.out.println("je trie");
		java.util.Arrays.sort(tableau);
		return tableau;
	}

	public static void main(String[] arg) {
	    String port;

	    if (arg.length == 0) port = "";
	    else port = arg[0];
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			Trieur trieur = new ServeurTri();
			Naming.rebind("//" + InetAddress.
				      getLocalHost().getHostName() + ":" + port +
				      "/Trieur", trieur);
			System.out.println("Enregistrement du trieur ");
		}
		catch (java.net.MalformedURLException e) {
			System.out.println("Mauvais nom de serveur ; " +
				e.getMessage());
			System.exit(1);
		}
		catch (UnknownHostException e) {
		  System.out.println("Hote inconnue");
		}
		catch (RemoteException e) {
			System.out.println("Probleme de connexion  : "
 				+ e.getMessage());
			System.exit(1);
		}
	}
}
