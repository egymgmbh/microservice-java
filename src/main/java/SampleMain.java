import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

/**
 * Starts the sample web application with embedded Jetty web server.
 */
public class SampleMain {
	// Embedded Jetty listening port.
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		final Server server = new Server();

		ServerConnector connector = new ServerConnector(server);
		connector.setPort(PORT);
		server.setConnectors(new Connector[] { connector });

		// Configure the Guice application.
		ServletContextHandler servletHandler = new ServletContextHandler();
		servletHandler.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
		servletHandler.addEventListener(new SampleServletContextListener());
		server.setHandler(servletHandler);

		// Start the server and wait for it.
		server.start();
		server.join();

		// TODO How to stop this thing?!
	}
}
