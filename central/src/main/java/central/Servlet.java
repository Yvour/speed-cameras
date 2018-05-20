package central;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camera.CameraMessageProcessor;
import camera.Message;
import camera.db.*;

import speed.SpeedAnalyser;
import speed.SpeedClass;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	private SQLiteMessageDAO dao = null;

	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
		response.getWriter().println("Hello World!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Message message = CameraMessageProcessor.getMessage(req);
		float speed = Float.parseFloat(message.getDetectedSpeed());
		System.out.println("The speed detected is " + speed);
		if (SpeedAnalyser.inspect(speed) != SpeedClass.SAFE) {
			System.out.println("Speed value of " + speed + " is unsafe, saving into database");
			this.dao.saveMessage(message);
		}

	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
		try {
			Class.forName("org.sqlite.JDBC");
			this.dao = new SQLiteMessageDAO("jdbc:sqlite:/tmp/cameras.db");
			this.dao.installStorage();
		} catch (Exception e) {

			throw new ServletException("Cannot init Storage");
		}
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}