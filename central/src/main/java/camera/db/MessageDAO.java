package camera.db;

import camera.Message;

public interface MessageDAO {

	public default void saveMessage(Message message) {
		
	}
}
