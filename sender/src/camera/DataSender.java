package camera;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataSender {
	public static String send() throws Exception {
		DataSet set = DataSetGenerator.generate();

		HttpURLConnection conn;
		URL mUrl = new URL("http://localhost:8080/central/rest");
		conn = (HttpURLConnection) mUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("User-Agent", "Speed-camera");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		conn.setDoOutput(true);

	//	ObjectMapper mapper = new ObjectMapper();
		String query = "the body";
		conn.addRequestProperty("Content-Type", "application/" + "POST");
		if (query != null) {
			conn.setRequestProperty("Content-Length", Integer.toString(query.length()));
			conn.getOutputStream().write(query.getBytes("UTF8"));
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

		}
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + mUrl);

		System.out.println("Response Code : " + responseCode);
		return "";
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				DataSender.send();
				System.out.println("after send");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}
}
