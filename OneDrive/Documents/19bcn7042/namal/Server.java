import java.io.IOException;
import java.net.ServerSocket;

import javax.net.ssl.SSLServerSocketFactory;
public class Server {
	public static void main(String[]args) throws IOException {
		System.setProperty("javax.net.ssl.trustStore", "namal");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		ServerSocket serverSocket = ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(4444);
		System.out.println("Server up and ready for connections.........");
		while(true)
			new ServerThread(serverSocket.accept()).start();
	}
}
