
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLSocketFactory;

public class Client {
	public static void main(String[]args) throws UnknownHostException,IOException {
		System.setProperty("javax.net.ssl.keyStore", "namal");
		Socket socket = ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket("localhost",4444);
		BufferedReader socketbufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader commandPromptBufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a name ");
		printwriter.println(commandPromptBufferedReader.readLine());
		String message = null;
		while(true) {
			System.out.println("Please enter a message to send to the server:");
			message = commandPromptBufferedReader.readLine();
			if(message.equals("quit")) {
			
				socket.close();
				break;
			}
			printwriter.println(message);
			System.out.print("Message reply from server: ");
			System.out.println(socketbufferedReader.readLine());
		
		}
	}

}
