package speed;

public class SpeedAnalyser {

	private static final float ALLOWED_LIMIT = (float) 60.00;
	private static final float SUPER_DANGEROUS_VALUE = (float) 130.00;

	public static SpeedClass inspect(float speed) {
		if (speed <= ALLOWED_LIMIT)
			return SpeedClass.SAFE;
		if (speed < SUPER_DANGEROUS_VALUE)
			return SpeedClass.OVER_LIMIT;
		return SpeedClass.SUPER_DANGEROUS;

	}
}
