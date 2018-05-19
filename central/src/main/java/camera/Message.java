package camera;

public class Message {
	private  String cameraId;
	private  String autoNumber;
	private  String detectedSpeed;
	private  String detectionTime;
	private  String photo;
	
	public Message() {
		// dummy constructor for Jackson
	}

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
