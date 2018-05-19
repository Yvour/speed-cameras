package speed;

public class SpeedAnalyser {

	private static final float ALLOWED_LIMIT = 60;
	private static final float SUPER_DANGEROUS_VALUE = 13;

	public static SpeedClass inspect(float speed) {
		if (speed <= ALLOWED_LIMIT)
			return SpeedClass.SAFE;
		if (speed < SUPER_DANGEROUS_VALUE)
			return SpeedClass.OVER_LIMIT;
		return SpeedClass.SUPER_DANGEROUS;

	}
}
