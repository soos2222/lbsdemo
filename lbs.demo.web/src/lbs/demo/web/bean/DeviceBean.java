package lbs.demo.web.bean;

import java.util.Date;

public class DeviceBean {

	private String id;

	private String deviceName;

	private String deviceNumber;

	private int deviceAge;

	private String deviceGender;

	private String deviceDescription;

	private String lastMotion;

	private Date lastUpdatedTime;

	private String labelType;

	private String profileImg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public int getDeviceAge() {
		return deviceAge;
	}

	public void setDeviceAge(int deviceAge) {
		this.deviceAge = deviceAge;
	}

	public String getDeviceGender() {
		return deviceGender;
	}

	public void setDeviceGender(String deviceGender) {
		this.deviceGender = deviceGender;
	}

	public String getDeviceDescription() {
		return deviceDescription;
	}

	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}

	public String getLastMotion() {
		return lastMotion;
	}

	public void setLastMotion(String lastMotion) {
		this.lastMotion = lastMotion;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

}
