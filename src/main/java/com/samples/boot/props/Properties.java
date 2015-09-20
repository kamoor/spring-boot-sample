package com.samples.boot.props;

public class Properties {

	java.util.Properties props = new java.util.Properties();

	static Properties properties = new Properties();

	public static Properties getInstance() {
		return properties;
	}

	public String getString(String key) {
		return props.getProperty(key);
	}

	public int getInt(String key) {
		try {
			return Integer.parseInt(props.getProperty(key));
		} catch (Exception e) {
			return 0;
		}

	}

	public void setProperty(String key, String value) {
		props.setProperty(key, value);
	}

}
