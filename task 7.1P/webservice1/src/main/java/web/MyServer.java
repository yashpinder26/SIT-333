package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;


public class MyServer {
	
	private static int PORT = 8082;
	
	public void start() throws Exception {
		
		Server server = new Server(PORT);
		
	
		ServletContextHandler handler = new ServletContextHandler(server, "/");
		
	
		handler.addServlet(WelcomeServlet.class, "/");
		

		handler.addServlet(LoginServlet.class, "/login");
		

		handler.addServlet(RegistrationServlet.class, "/reg");
		
		System.out.println("Server started!");
		server.start();
	}

	public static void main(String[] args) throws Exception {
		new MyServer().start();
	}
}
