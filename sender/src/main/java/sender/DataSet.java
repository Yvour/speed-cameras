package sender;

public class DataSet {
	public final String cameraId;
	public final String autoNumber;
	public final String detectedSpeed;
	public final String detectionTime;
	public final String photo;

	public DataSet(String cameraId, String autoNumber, String detectedSpeed,
			String detectionTime, String photo) {
		super();
		this.cameraId = cameraId;
		this.autoNumber = autoNumber;
		this.detectedSpeed = detectedSpeed;
		this.detectionTime = detectionTime;
		this.photo = photo;
	}
}