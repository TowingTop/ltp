package top.towing.ltp.testbed.entity;

import java.util.List;

public class Session {
	private String id;
	private List<Message> messages;

	public Session(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
