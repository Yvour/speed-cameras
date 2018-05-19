package camera;

public class Message {
	public final String cameraId;
	public final String autoNumber;
	public final String detectedSpeed;
	public final String detectionTime;
	public final String photo;

	public Message(String cameraId, String autoNumber, String detectedSpeed,
			String detectionTime, String photo) {
		super();
		this.cameraId = cameraId;
		this.autoNumber = autoNumber;
		this.detectedSpeed = detectedSpeed;
		this.detectionTime = detectionTime;
		this.photo = photo;
	}

	/**
	 * @return the cameraId
	 */
	public String getCameraId() {
		return cameraId;
	}

	/**
	 * @return the autoNumber
	 */
	public String getAutoNumber() {
		return autoNumber;
	}

	/**
	 * @return the detectedSpeed
	 */
	public String getDetectedSpeed() {
		return detectedSpeed;
	}

	/**
	 * @return the detectionTime
	 */
	public String getDetectionTime() {
		return detectionTime;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	
	
	
}
