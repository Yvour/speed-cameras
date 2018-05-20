package camera.db;

import camera.Message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteMessageDAO implements MessageDAO {

	private Connection getConnection(String url) {
		Connection conn = null;
		try {

			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public SQLiteMessageDAO(String url) {
		this.connection = getConnection(url);
		;
	}

	private static final String INSERT_SQL = "INSERT INTO camera_messages " +

			"(camera_id, car_number, speed, time, photo  )" + "values (?, ?, ?, ?, ?)";

	private static final String INSTALLATION_SQL = "CREATE TABLE IF NOT EXISTS camera_messages " + " (camera_id text, "
			+ " car_number text, " + " speed text, " + " time text ," + "photo text " + ")";

	private Connection connection;

	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void installStorage() {
		Statement st = null;
		{
			try {
				st = connection.createStatement();
				st.executeUpdate(INSTALLATION_SQL);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(st);
			}
		}

	}

	public void saveMessage(Message message) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT_SQL);
			ps.setString(1, message.getCameraId());
			ps.setString(2, message.getAutoNumber());
			ps.setString(3, message.getDetectedSpeed());
			ps.setString(4, message.getDetectionTime());
			ps.setString(5, message.getPhoto());

			int numRowsInserted = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

}
