package com.bostonunisoft.students.monopoly.model.domain;

import java.io.Serializable;

/**
 * Class that represents Player entity.
 * 
 * @author Yura
 */
public class Player implements Serializable {
	private static final long serialVersionUID = 8616288194334239951L;
	private long id;
	private String email;
	private String pass;
	private String nickName;
	private boolean sex;
	private String avatar;

	public Player() {
	}

	public Player(Long id, String email, String pass, String nickName,
			boolean sex, String avatar) {
		super();
		if (id != null) {
			this.id = id;
		} else {
			this.id = 0;
		}
		this.email = email;
		this.pass = pass;
		this.nickName = nickName;
		this.sex = sex;
		this.avatar = avatar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
