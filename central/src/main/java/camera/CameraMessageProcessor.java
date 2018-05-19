package camera;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CameraMessageProcessor {
	
	private static String getPostRequestBody(HttpServletRequest req) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			reader = req.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	public static Message getMessage(HttpServletRequest req) {
		String body = getPostRequestBody(req);
		ObjectMapper mapper = new ObjectMapper();
		Message message = null;
		try {
			message = mapper.readValue(body, Message.class);
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		return message;
	}

}
