package com.milan.mn.model;

public class EmailModel {
	
	public String from;
	public String fromName;
	public String to;
	public String toName;
	public String body;
	public String subject;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "EmailModel [from=" + from + ", to=" + to + ", body=" + body + ", subject=" + subject + "]";
	}

}
