package com.tistory.johnmark.javareflection.logging;

public class LogDTO {
	private String normalMessage;
	@Masking
	private String sensitiveMessage;
	private int value;

	public LogDTO() {
	}

	public LogDTO(String normalMessage, String sensitiveMessage, int value) {
		this.normalMessage = normalMessage;
		this.sensitiveMessage = sensitiveMessage;
		this.value = value;
	}

	public String getNormalMessage() {
		return normalMessage;
	}

	public void setNormalMessage(String normalMessage) {
		this.normalMessage = normalMessage;
	}

	public String getSensitiveMessage() {
		return sensitiveMessage;
	}

	public void setSensitiveMessage(String sensitiveMessage) {
		this.sensitiveMessage = sensitiveMessage;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "LogDTO{" +
			"normalMessage='" + normalMessage + '\'' +
			", sensitiveMessage='" + sensitiveMessage + '\'' +
			", value=" + value +
			'}';
	}
}
