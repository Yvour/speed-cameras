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
import speed.SpeedAnalyser;
import speed.SpeedClass;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
		response.getWriter().println("Hello World!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        Message message = CameraMessageProcessor.getMessage(req);
        float speed = Float.parseFloat(message.getDetectedSpeed());
        if (SpeedAnalyser.inspect(speed)!= SpeedClass.SAFE) {
        	message.saveToDatabase()
        }
	
	
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}