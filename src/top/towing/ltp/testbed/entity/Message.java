package top.towing.ltp.testbed.entity;

import java.util.Date;

public class Message {
	private Date timeStamp;
	private String senderName;
	private String senderRole;
	private String content;
	
	public Message(Date timeStamp, String senderName, String senderRole, String content) {
		this.timeStamp = timeStamp;
		this.senderName = senderName;
		this.senderRole = senderRole;
		this.content = content;
	}
	
	public String getSenderName() {
		return senderName;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String getSenderRole() {
		return senderRole;
	}
	
	public void setSenderRole(String senderRole) {
		this.senderRole = senderRole;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
