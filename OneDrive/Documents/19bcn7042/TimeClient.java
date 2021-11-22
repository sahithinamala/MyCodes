import java.net.*;
import java.io.*;
import java.util.*;
public class TimeClient {    
  public final static int    DEFAULT_PORT = 37;
  public final static String DEFAULT_HOST = "time.nist.gov";
  public static void main(String[] args) {
    String hostname = DEFAULT_HOST ;
    int port = DEFAULT_PORT; 
    if (args.length > 0) {
      hostname = args[0];
    }
    if (args.length > 1) {
      try { 
        port = Integer.parseInt(args[1]);
      }
      catch (NumberFormatException ex) {
           } 
    }
     long differenceBetweenEpochs = 2208988800L; 
    InputStream raw = null;
    try {
      Socket theSocket = new Socket(hostname, port);
      raw = theSocket.getInputStream();
      long secondsSince1900 = 0;
      for (int i = 0; i < 4; i++) {
        secondsSince1900 = (secondsSince1900 << 8) | raw.read();
      }
      long secondsSince1970 
       = secondsSince1900 - differenceBetweenEpochs;       
      long msSince1970 = secondsSince1970 * 1000;
      Date time = new Date(msSince1970);    
      System.out.println("It is " + time + " at " + hostname);
    } 
    catch (UnknownHostException ex) {
      System.err.println(ex);
    }
    catch (IOException ex) {
      System.err.println(ex);
    }
    finally {
      try {
        if (raw != null) raw.close(); 
      }
      catch (IOException ex) {}
    }
  }  // end main

} // end TimeClient
