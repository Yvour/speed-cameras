package sender;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataSetGenerator {
	private static int CAMERA_RANGE = 40;
	private static float MIN_SPEED = 40;
	private static float MAX_SPEED = 130;
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static DataSet generate() {
		Random rand = new Random();
		return new DataSet(String.valueOf(rand.nextInt(CAMERA_RANGE)),
				String.valueOf(rand.nextInt(1000)), String.valueOf(rand
						.nextFloat() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED),
				String.valueOf(df.format(new Date())), "no photo");
	}
	
	


}
