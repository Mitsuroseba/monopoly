package com.bostonunisoft.students.monopoly.helpers.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bostonunisoft.students.monopoly.config.DBConfig;

/**
 * Class-connector, configured by interface DBConfing, returns connection to
 * Postgrees database, if it's possible, or null, if there are some troubles
 * with database connection.
 * 
 * @author Yura
 * 
 */
public class Connector implements DBConfig {
	private static Logger logger = Logger.getLogger(Connector.class);
	private static Connection connection;

	static {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://"
					+ host + ":" + port + "/" + dataBaseName, userName,
					password);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			connection = null;
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
