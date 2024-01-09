package com.Alpha.Alpha.Model;

public class ApprovalMessage {

	private String to;
	private String message;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;

	}

	@Override
	public String toString() {
		return "ApprovalMessage [to=" + to + ", message=" + message + "]";
	}

	public ApprovalMessage(String to, String message) {
		super();
		this.to = to;
		this.message = message;
	}

	public ApprovalMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
