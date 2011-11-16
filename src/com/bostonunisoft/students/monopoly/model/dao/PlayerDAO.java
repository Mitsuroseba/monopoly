package com.bostonunisoft.students.monopoly.model.dao;

import com.bostonunisoft.students.monopoly.exceptions.DataBaseConnectionException;
import com.bostonunisoft.students.monopoly.helpers.errors.ErrorCode;
import com.bostonunisoft.students.monopoly.model.domain.Player;

public interface PlayerDAO {
	ErrorCode savePlayer(Player player);

	Player getPlayerByEmail(String email) throws DataBaseConnectionException;

	Player getPlayerByNickName(String nickName)
			throws DataBaseConnectionException;

	ErrorCode updatePlayer(Player player);
}
