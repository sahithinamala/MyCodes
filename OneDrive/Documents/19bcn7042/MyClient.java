import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class MyClient{

  public static void main(String[] args) throws Exception {
    SocketFactory sf = SSLSocketFactory.getDefault();
    Socket s = sf.createSocket(args[0], Integer.parseInt(args[1]));

    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter pw = new PrintWriter(s.getOutputStream());
    System.out.println("Who is Sylvia?");
    pw.println("Who is Sylvia?");
    pw.flush();
    System.out.println(br.readLine());
    s.close();
  }
}