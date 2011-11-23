/**
 * 
 */
package com.bostonunisoft.students.monopoly.model.service.impl;

import com.bostonunisoft.students.monopoly.exceptions.DataBaseConnectionException;
import com.bostonunisoft.students.monopoly.helpers.errors.ErrorCode;
import com.bostonunisoft.students.monopoly.model.dao.impl.PlayerDAOImpl;
import com.bostonunisoft.students.monopoly.model.domain.Player;
import com.bostonunisoft.students.monopoly.model.service.PlayerService;

/**
 * @author Mike
 * 
 */
public class PlayerServiceImpl implements PlayerService {

	PlayerDAOImpl playerDAOImp = new PlayerDAOImpl();

	@Override
	public ErrorCode Register(String email, String pass, String nickName,
			boolean sex, String avatar) {
		Player player = new Player();

		player.setEmail(email);
		player.setPass(pass);
		player.setNickName(nickName);
		player.setSex(sex);
		player.setAvatar(avatar);

		return playerDAOImp.savePlayer(player);
	}

	@Override
	public ErrorCode Login(String email, String pass) {
		Player player;
		try {
			player = playerDAOImp.getPlayerByEmail(email);
		} catch (DataBaseConnectionException e) {
			return ErrorCode.DATABASE_ERROR;
		}

		if (player != null && player.getPass().equals(pass)) {
			return ErrorCode.SUCCESS;
		} else {
			return ErrorCode.VALIDATION_ERROR;
		}

	}

	@Override
	public ErrorCode Logout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorCode Edit(String email, String pass, String nickName,
			boolean sex, String avatar) {
		Player player = new Player();

		player.setEmail(email);
		player.setPass(pass);
		player.setNickName(nickName);
		player.setSex(sex);
		player.setAvatar(avatar);

		return playerDAOImp.updatePlayer(player);
	}

}
