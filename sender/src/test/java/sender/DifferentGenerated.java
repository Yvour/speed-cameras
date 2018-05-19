package sender;

import static org.junit.Assert.*;

import org.junit.Test;

public class DifferentGenerated {
	private final int COUNT = 100;
	private final int ALLOWED_COUNCIDENCE_COUNT = 1;

	@Test
	public void test() {

		DataSet[] arr = new DataSet[COUNT];
		for (int i = 0; i< arr.length; i ++) {
			arr[i] = DataSetGenerator.generate();
		}
		int equalCount = 0;
		String instance = arr[0].detectedSpeed;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].detectedSpeed.equals(instance)) {
				equalCount++;
			}
		}
				
		if (equalCount > ALLOWED_COUNCIDENCE_COUNT) {		
		fail("Speed values are not generated randomly");
		}
		
	}

}
