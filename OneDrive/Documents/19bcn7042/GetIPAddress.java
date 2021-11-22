import java.net.*; 
import java.io.*; 
import java.util.*;
public class GetIPAddress{
public static void main(String[] args )throws IOException {
BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
System.out.print("Enter the host name: ");
String hostname = input.readLine(); 
ServerSocket s=new ServerSocket(8081);
try {
InetAddress inetadd = InetAddress.getByName(hostname); 
System.out.println("IP address is: " + inetadd.getHostAddress());
Socket soc=s.accept();
DataOutputStream out=new DataOutputStream(soc.getOutputStream()); 
out.writeBytes("Server Date: " + (new Date()).toString() + "\n");
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream() )); 
System.out.println(in.readLine());
out.close();
soc.close();
}
catch(UnknownHostException e ){
 
System.out.println("Could not find IP address for: " + hostname);
}
}
}