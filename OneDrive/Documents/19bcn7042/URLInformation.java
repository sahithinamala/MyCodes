import java.net.*;
import java.io.*;
import java.util.Date;
public class URLInformation
{
public static void main(String args[]) throws Exception
{
 int c;
 URL url = new URL("http://sahithi-lifetour.blogspot.com/");
 URLConnection con = url.openConnection();
 System.out.println("");
 System.out.println("Date: " + new Date(con.getDate()));
 System.out.println("Content-Type: " + con.getContentType());
 System.out.println("Expires: " + con.getExpiration());
 System.out.println("Last-Modified: " + new Date(con.getLastModified()));
 int len = con.getContentLength();
 System.out.println("Content-Length: " + len);
 if (len > 0)
 {
 System.out.println("=== Content ===");
 InputStream input = con.getInputStream();
 int i = len;
 while(((c = input.read()) != -1) && (-i > 0))
 {
 System.out.print((char) c);
 }
 input.close();
 }
 else
 {
 System.out.println("No Content Available");
 }
 }
}