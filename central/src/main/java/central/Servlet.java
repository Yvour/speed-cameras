package central;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import camera.CameraMessageProcessor;
import camera.Message;
import camera.db.SQLiteMessageDAO;
import speed.SpeedAnalyser;
import speed.SpeedClass;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	SQLiteMessageDAO dao = null;
	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
		response.getWriter().println("Hello World!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Message message = CameraMessageProcessor.getMessage(req);
		float speed = Float.parseFloat(message.getDetectedSpeed());
		if (SpeedAnalyser.inspect(speed) != SpeedClass.SAFE) {
			this.dao.saveMessage(message);
		}

	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
		this.dao = new SQLiteMessageDAO("jdbc:sqlite:C:/sqlite/db/camera.db");
		this.dao.installStorage();
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}