package central;

import static org.junit.Assert.*;


import speed.SpeedAnalyser;
import speed.SpeedClass;

class InspectionTest {

	@Test
	void inspectorTest() {
		
		Field allowed = null;
		Field superDangerous = null;
		try {
			allowed = SpeedAnalyser.class.getDeclaredField("ALLOWED_LIMIT");
		}
		catch (NoSuchFieldException e) {
			fail("Class SpeedAnalyzer does not contain ALLOWED_LIMIT field");
		}
		try {
			superDangerous = 		SpeedAnalyser.class.getDeclaredField("SUPER_DANGEROUS_VALUE");
		}
		catch (NoSuchFieldException e) {
			fail("Class SpeedAnalyzer does not contain SUPER_DANGEROUS_VALUE field");
		}
		float floatAllowed;
		float floatSuperDangerous;
		if (float.class == allowed.getType()) {
			 floatAllowed = allowed.getFloat(null);
			if (!(floatAllowed > 0)) {
				fail("Allowed value is to be positive");
			}
			if (SpeedAnalyser.inspect(floatAllowed)!=SpeedClass.SAFE) {
				fail("Maximal allowed value is not violation");
			}
			if (SpeedAnalyser.inspect(floatAllowed-1)!=SpeedClass.SAFE) {
				fail("Values less than maxinal allowed is not violation");
			}
			if (SpeedAnalyser.inspect(floatAllowed/2)!=SpeedClass.SAFE) {
				fail("Half of  maxinal allowed is not violation");
			}
		}
		else {
			fail("Allowed speed value should be float");
		}
		if (float.class == superDangerous.getType()) {
			 floatSuperDangerous = superDangerous.getFloat(null);
			if (!(floatSuperDangerous > 0)) {
				fail("Super dangerous value is to be positive");
			}
			if (!(floatSuperDangerous > floatAllowed)) {
				fail("Super dangerous value is to be more than allowed");
			}
		}
		else {
			fail("Seper dangerous value is to be float");
		}
		fail("Not yet implemented");
	}

}
