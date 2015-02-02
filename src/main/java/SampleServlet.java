import com.google.inject.Singleton;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A sample servlet returning some dummy HTML.
 */
@Singleton
class SampleServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h2>You have successfully embedded Jetty! Happy coding!</h2>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
