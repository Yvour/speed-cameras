package speed;

public class SpeedAnalyser {

	public static float ALLOWED_LIMIT = 60;
	public static float SUPER_DANGEROUS_VALUE = 130;
	
	public static SpeedClass inspect(float speed) {
		if (speed <=ALLOWED_LIMIT)
			return SpeedClass.SAFE;
		if (speed < SUPER_DANGEROUS_VALUE)
			return SpeedClass.OVER_LIMIT;
		return SpeedClass.SUPER_DANGEROUS;
		
	}
}
