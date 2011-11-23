package com.bostonunisoft.students.monopoly.exceptions;

public class DataBaseConnectionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6324357543461176357L;
	private String message = "There are some troubles with database connection.";

	public String getMessage() {
		return message;
	}
}
