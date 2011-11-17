package com.bostonunisoft.students.monopoly.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bostonunisoft.students.monopoly.exceptions.DataBaseConnectionException;
import com.bostonunisoft.students.monopoly.helpers.db.Connector;
import com.bostonunisoft.students.monopoly.helpers.errors.ErrorCode;
import com.bostonunisoft.students.monopoly.model.dao.PlayerDAO;
import com.bostonunisoft.students.monopoly.model.domain.Player;

/**
 * Implementation of PlayerDAO.
 * 
 * @author Yura
 * 
 */
public class PlayerDAOImpl implements PlayerDAO {
	private Logger logger = Logger.getLogger(PlayerDAOImpl.class);
	private Connection connection;

	/**
	 * Saves player to database.
	 * 
	 * @param player
	 *            - Player to be saved.
	 * @return ErrorCode.SUCCESS if player was saved and
	 *         ErrorCode.DATABASE_ERROR if there were problems.
	 */
	@Override
	public ErrorCode savePlayer(Player player) {
		if (Connector.getConnection() != null) {
			connection = Connector.getConnection();
			try {
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO users(email,pass,nickname,sex,avatar) VALUES(?,?,?,?,?)");
				ps.setString(1, player.getEmail());
				ps.setString(2, player.getPass());
				ps.setString(3, player.getNickName());
				ps.setBoolean(4, player.isSex());
				ps.setString(5, player.getAvatar());
				ps.executeUpdate();
				ps.close();
				return ErrorCode.SUCCESS;
			} catch (SQLException e) {
				logger.error(e.getMessage());
				return ErrorCode.DATABASE_ERROR;
			}
		} else {
			return ErrorCode.DATABASE_ERROR;
		}
	}

	/**
	 * Gets player by email.
	 * 
	 * @param email
	 *            - player's email.
	 * @throws DataBaseConnectionException
	 *             if there are some problems with connection.
	 * @return Player, if there is player with such email, null if not and
	 *         throws exception if there are problems with connection.
	 */
	@Override
	public Player getPlayerByEmail(String email)
			throws DataBaseConnectionException {
		if (Connector.getConnection() != null) {
			connection = Connector.getConnection();
			try {
				PreparedStatement ps = connection
						.prepareStatement("SELECT * FROM users WHERE email=?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return new Player(rs.getLong("id"), rs.getString("email"),
							rs.getString("pass"), rs.getString("nickname"),
							rs.getBoolean("sex"), rs.getString("avatar"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new DataBaseConnectionException();
			}
		} else {
			logger.error("Connection error");
			throw new DataBaseConnectionException();
		}
	}

	/**
	 * Gets player by nickname.
	 * 
	 * @param nickName
	 *            - player's nickname.
	 * @throws DataBaseConnectionException
	 *             if there are some problems with connection.
	 * @return Player, if there is player with such nickName, null if not and
	 *         throws exception if there are problems with connection.
	 */
	@Override
	public Player getPlayerByNickName(String nickName)
			throws DataBaseConnectionException {
		if (Connector.getConnection() != null) {
			connection = Connector.getConnection();
			try {
				PreparedStatement ps = connection
						.prepareStatement("SELECT * FROM users WHERE nickname=?");
				ps.setString(1, nickName);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return new Player(rs.getLong("id"), rs.getString("email"),
							rs.getString("pass"), rs.getString("nickname"),
							rs.getBoolean("sex"), rs.getString("avatar"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new DataBaseConnectionException();
			}
		} else {
			logger.error("Connection error");
			throw new DataBaseConnectionException();
		}
	}

	/**
	 * Updates player to database.
	 * 
	 * @param player
	 *            - Player to be updated.
	 * @return ErrorCode.SUCCESS if player was updates and
	 *         ErrorCode.DATABASE_ERROR if there were problems.
	 */
	@Override
	public ErrorCode updatePlayer(Player player) {
		if (Connector.getConnection() != null) {
			connection = Connector.getConnection();
			try {
				PreparedStatement ps = connection
						.prepareStatement("UPDATE users SET email=?,pass=?,nickname=?,sex=?,avatar=? WHERE id=?");
				ps.setString(1, player.getEmail());
				ps.setString(2, player.getPass());
				ps.setString(3, player.getNickName());
				ps.setBoolean(4, player.isSex());
				ps.setString(5, player.getAvatar());
				ps.setLong(6, player.getId());
				ps.executeUpdate();
				ps.close();
				return ErrorCode.SUCCESS;
			} catch (SQLException e) {
				logger.error(e.getMessage());
				return ErrorCode.DATABASE_ERROR;
			}
		} else {
			return ErrorCode.DATABASE_ERROR;
		}
	}

}
