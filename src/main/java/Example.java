/**
 * This file is part of the source code and related artifacts for eGym Application.
 *
 * Copyright © 2013 eGym GmbH
 */

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.google.inject.servlet.GuiceFilter;


public class Example {


	// embedded Jetty listening port
	private static final int PORT = 8080;

	public static void main(String[] args){

		final Server server = new Server();

		ServerConnector connector = new ServerConnector(server);
		connector.setPort(PORT);
		server.setConnectors(new Connector[] {connector});

		ServletContextHandler servletHandler = new ServletContextHandler();

		servletHandler.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
		servletHandler.addServlet(new ServletHolder(new SuccessServlet()), "/*");
		servletHandler.addEventListener(new ServletContextListener() {

			ServletContext context;

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				System.out.println("Context created!");
				context = sce.getServletContext();
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				context = sce.getServletContext();
				System.out.println("Context destroyed!");

			}
		});

		server.setHandler(servletHandler);
		try{
			server.start();
			server.join();
		} catch (Exception e){

			System.out.println("Starting embedded Jetty failed.");
		}


	}

}
