import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.*;

public class ReadHTTP {
    public static void main(String[] args) throws Exception {
        String s = "";
        URL url = new URL("http://info.cern.ch");
        URLConnection uc = url.openConnection();
        InputStream raw = uc.getInputStream();
        InputStream buffer = new BufferedInputStream(raw);
        Reader r = new InputStreamReader(buffer);
        int c;
        while ((c = r.read()) != -1) {
            s += (char)c;
        }
        System.out.println("Reading Data from : http://info.cern.ch");
        WriteHTTP a = new WriteHTTP();
        a.launchServer(s);

    }
}
class WriteHTTP {

    public void launchServer(String content) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/home", new MyHandler(content));
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("http://localhost:8000/home");
    }

    static class MyHandler implements HttpHandler {
        String content="";
        MyHandler(String s){
            content=s;
        }
        @Override
        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, content.length());
            OutputStream os = t.getResponseBody();
            os.write(content.getBytes());
            os.close();
        }
    }
}