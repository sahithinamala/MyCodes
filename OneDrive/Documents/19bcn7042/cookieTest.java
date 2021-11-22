// Java program to illustrate methods 
// of Cookie class 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.List; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.Cookie; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

/** 
* Servlet implementation class cookieTest 
*/
@WebServlet("/cookieTest") 
public class cookieTest extends HttpServlet 
{ 
	private static final long serialVersionUID = 1L; 

	/** 
	* @see HttpServlet#HttpServlet() 
	*/
	public cookieTest() { 
		super(); 
		// TODO Auto-generated constructor stub 
	} 

	/** 
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	*	 response) 
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{ 

		response.setContentType("text/html"); 
		// Create a new cookie with the name test cookie 
		// and value 123 
		Cookie cookie = new Cookie("test_cookie", "123"); 

		// setComment() method 
		cookie.setComment("Just for testing"); 

		// setDomain() method 
		// cookie.setDomain("domain"); 

		// setMaxAge() method 
		cookie.setMaxAge(3600); 

		// setPath() method 
		cookie.setPath("/articles"); 

		// setSecure() method 
		cookie.setSecure(false); 

		// setValue() method 
		cookie.setValue("321"); 

		// setVersion() method 
		cookie.setVersion(0); 

		response.addCookie(cookie); 

		PrintWriter pw = response.getWriter(); 
		pw.print("<html><head></head><body>"); 
		Cookie ck[] = request.getCookies(); 

		if (ck == null) { 
			pw.print("<p>This is first time the page is requested.</p>"); 
			pw.print("<p>And therefore no cookies found</p></body></html>"); 
		} else { 
			pw.print("<p>Welcome Again...Cookies found</p>"); 
			for (int i = 0; i < ck.length; i++) { 

				// getName() method 
				pw.print("<p>Name :" + ck[i].getName() + "</p>"); 

				// getValue() method 
				pw.print("<p>Value :" + ck[i].getValue() + "</p>"); 

				// getDomain() method 
				pw.print("<p>Domain :" + ck[i].getDomain() + "</p>"); 

				// getPath() method 
				pw.print("<p>Name :" + ck[i].getPath() + "</p>"); 

				// getMaxAge() method 
				pw.print("<p>Max Age :" + ck[i].getMaxAge() + "</p>"); 

				// getComment() method 
				pw.print("<p>Comment :" + ck[i].getComment() + "</p>"); 

				// getSecure() method 
				pw.print("<p>Name :" + ck[i].getSecure() + "</p>"); 

				// getVersion() method 
				pw.print("<p>Version :" + ck[i].getVersion() + "</p>"); 
			} 
			pw.print("<body></html>"); 

		} 
		pw.close(); 
	} 

	/** 
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	*	 response) 
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{ 
	
		doGet(request, response); 
	} 

} 

