package com.example.demo.responsestatus;

public enum ResponseStatus {

	OK("ok", "S00"),

	ERROR("error", "F00");

	private ResponseStatus() {

	}

	private String key;

	private String value;

	private ResponseStatus(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static ResponseStatus getEnumByValue(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (ResponseStatus v : values())
			if (value.equalsIgnoreCase(v.getValue()))
				return v;
		throw new IllegalArgumentException();
	}

	public static ResponseStatus getEnumByKey(String key) {
		if (key == null)
			throw new IllegalArgumentException();
		for (ResponseStatus v : values())
			if (key.equalsIgnoreCase(v.getKey()))
				return v;
		throw new IllegalArgumentException();
	}

}
