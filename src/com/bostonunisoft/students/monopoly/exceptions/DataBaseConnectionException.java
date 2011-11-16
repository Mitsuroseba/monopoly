package com.bostonunisoft.students.monopoly.exceptions;

public class DataBaseConnectionException extends Exception {
	private String message = "There are some troubles with database connection.";

	public String getMessage() {
		return message;
	}
}
