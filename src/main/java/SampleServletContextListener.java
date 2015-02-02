import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * Responsible for configuring the application's Guice injector.
 */
class SampleServletContextListener extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		// Create and configure the application's injector
		return Guice.createInjector(new ServletModule() {
			@Override
			protected void configureServlets() {
				// Serve everything with the SampleServlet.
				serve("/*").with(SampleServlet.class);
			}
		});
	}
}
