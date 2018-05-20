package central;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import speed.SpeedAnalyser;
import speed.SpeedClass;

public class InspectionTest {
	private static String ALLOWED_VALUE_FIELD_NAME = "ALLOWED_LIMIT";
	private static String DANGEROUS_VALUE_FIELD_NAME = "SUPER_DANGEROUS_VALUE";
	private static float[] VERY_BIG_SPEED_VALUES = new float[] { 500, 700, 1000, 10000000 };

	@Test
	public void inspectorTest() {

		Field allowedValueField = null;
		Field dangerousValueField = null;
		;
		try {
			allowedValueField = SpeedAnalyser.class.getDeclaredField(ALLOWED_VALUE_FIELD_NAME);
			allowedValueField.setAccessible(true);
			;
		} catch (NoSuchFieldException e) {
			fail("Class SpeedAnalyzer does not contain " + ALLOWED_VALUE_FIELD_NAME + " field");
		}
		try {
			dangerousValueField = SpeedAnalyser.class.getDeclaredField(DANGEROUS_VALUE_FIELD_NAME);
			dangerousValueField.setAccessible(true);
		} catch (NoSuchFieldException e) {
			fail("Class SpeedAnalyzer does not contain " + DANGEROUS_VALUE_FIELD_NAME + " field");
		}
		float floatAllowed = 0;
		float floatSuperDangerous = 0;
		if (float.class == allowedValueField.getType()) {
			try {
				floatAllowed = allowedValueField.getFloat(null);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				fail(e.getMessage());
			}

		} else {
			fail("Allowed speed value should be float");
		}
		if (float.class == dangerousValueField.getType()) {
			try {
				floatSuperDangerous = dangerousValueField.getFloat(null);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail(e.getMessage());
			}

		} else {
			fail("Dangerous value is to be float");
		}
        // Checking the values and the classification given by class
		if (!(floatAllowed > 0)) {
			fail("Allowed value is to be positive");
		}
		if (SpeedAnalyser.inspect(floatAllowed) != SpeedClass.SAFE) {
			fail("Maximal allowed value is not violation");
		}
		if (SpeedAnalyser.inspect(floatAllowed - 1) != SpeedClass.SAFE) {
			fail("Values less than maxinal allowed is not violation");
		}
		if (SpeedAnalyser.inspect(floatAllowed / 2) != SpeedClass.SAFE) {
			fail("Half of  maxinal allowed is not violation");
		}

		if (!(floatSuperDangerous > 0)) {
			fail("dangerousValueField value is to be positive");
		}
		if (!(floatSuperDangerous > floatAllowed)) {
			fail("dangerousValueField value is to be more than allowed");
		}
		if (SpeedAnalyser.inspect((floatAllowed + floatSuperDangerous) / 2) != SpeedClass.OVER_LIMIT) {
			fail("The value between allowed and super dangerous should be classified as \"Over Limit \"");
		}
		if (SpeedAnalyser.inspect(floatSuperDangerous) != SpeedClass.SUPER_DANGEROUS) {
			fail("Speed value that equals super dangerous value should be classifed as \"Super dangerous\"");

		}
		for (int i = 1; i < 100; i++) {
			float valueOverSuperDangerous = floatSuperDangerous + i;
			SpeedClass classifier = SpeedAnalyser.inspect(valueOverSuperDangerous) ;
			if (classifier != SpeedClass.SUPER_DANGEROUS) {
				fail("Speed value over super dangerous " + String.valueOf(valueOverSuperDangerous) + " should be classified as \"Super dangerous\". It classified as " + classifier.toString());
			}
		}
		// Maybe it is reasonable to classify very big values as unreal or as check
		// needed values
		for (int i = 0; i < VERY_BIG_SPEED_VALUES.length; i++) {
			if (SpeedAnalyser.inspect(VERY_BIG_SPEED_VALUES[i]) == SpeedClass.SUPER_DANGEROUS) {
				fail("Very big speed value " + String.valueOf(VERY_BIG_SPEED_VALUES[i])
						+ " should be classified as \"Super dangerous\"");
			}

		}

	}

}
