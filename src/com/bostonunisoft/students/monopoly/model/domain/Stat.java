package com.bostonunisoft.students.monopoly.model.domain;

import java.io.Serializable;

/**
 * Class that represents player's statistics entity.
 * 
 * @author Yura
 */
public class Stat implements Serializable {
	private static final long serialVersionUID = 5326802417859525510L;
	private long userId;
	private int gameCount;
	private int victoryCount;
	private int leaveCount;
	private int points;

	public Stat() {
	}

	public Stat(long userId, int gameCount, int victoryCount, int leaveCount,
			int points) {
		super();
		this.userId = userId;
		this.gameCount = gameCount;
		this.victoryCount = victoryCount;
		this.leaveCount = leaveCount;
		this.points = points;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}

	public int getVictoryCount() {
		return victoryCount;
	}

	public void setVictoryCount(int victoryCount) {
		this.victoryCount = victoryCount;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
