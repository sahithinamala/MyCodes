import java.net.*;
import java.io.*;
public class FormPoster {
	private URL url;
	private QueryString query = null;
	public FormPoster (URL url) {
		if (!url.getProtocol().toLowerCase( ).startsWith("http")) {
			throw new IllegalArgumentException("Posting only works for http URLs");
		}
		this.url = url;
	}
	public void add(String name, String value) {
		if (query == null)
		 query = new QueryString(name, value);
		query.add(name, value);
	}
	public URL getURL( ) {
		return this.url;
	}
	public InputStream post( ) throws IOException {
		// open the connection and prepare it to POST
		URLConnection uc = url.openConnection( );
		uc.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream( ), "ASCII");
		// The POST line, the Content-type header,
		// and the Content-length headers are sent by the URLConnection.
		// We just need to send the data
		out.write(query.toString( ));
		out.write("\r\n");
		out.flush( );
		out.close( );
		// Return the response
		return uc.getInputStream( );
	}
	public static void main(String args[]) throws Exception{
		URL url;
		if (args.length > 0) {
		try {
			url = new URL(args[0]);
		}
		catch (MalformedURLException ex) {
			System.err.println("Usage: java FormPoster url");
			return;
		}
		}
		else {
			try {
				url = new URL("");
			}	
			catch (MalformedURLException ex) { // shouldn't happen
				System.err.println(ex);
				return;
			}
		}
		FormPoster poster = new FormPoster(url);
		poster.add("name", "vit-ap");
		poster.add("email", "vitap@vitap.ac.in");
		try {
			InputStream in = poster.post( );
			// Read the response
			InputStreamReader r = new InputStreamReader(in);
			int c;
			while((c = r.read( )) != -1) {
				System.out.print((char) c);
			}
			System.out.println( );
			in.close( );
		}
		catch (IOException ex) {
			System.err.println(ex);
			}
	}
}
class QueryString {

	private String query = "";
  
	public QueryString(String name, String value) {
	  encode(name, value);
	}
  
	public void add(String name, String value) {
	  query += "&";
	  encode(name, value);
	}
  
	private void encode(String name, String value) {
	  try {
		query +=URLEncoder.encode(name, "UTF-8");
		query += "=";
		query += URLEncoder.encode(value, "UTF-8");
	  } catch (UnsupportedEncodingException ex) {
		throw new RuntimeException("Broken VM does not support UTF-8");
	  }
	}
  
	public String getQuery() {
	  return query;
	}
  
	public String toString() {
	  return getQuery();
	}
  
  }