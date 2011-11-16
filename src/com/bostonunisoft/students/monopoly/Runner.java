package com.bostonunisoft.students.monopoly;

import com.bostonunisoft.students.monopoly.exceptions.DataBaseConnectionException;
import com.bostonunisoft.students.monopoly.model.dao.impl.PlayerDAOImpl;
import com.bostonunisoft.students.monopoly.model.domain.Player;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello Monopoly!");
		PlayerDAOImpl dao = new PlayerDAOImpl();
		dao.savePlayer(new Player(null,"demyura@gmail.com", "password", "DemYura",
				true, "demyura.jpg"));
		Player player;
		try {
			player = dao.getPlayerByEmail("demyura@gmail.com");
			player.setNickName("newNick");
			dao.updatePlayer(player);
		} catch (DataBaseConnectionException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
