/**
 * 
 */
package com.bostonunisoft.students.monopoly.model.service;

import com.bostonunisoft.students.monopoly.helpers.errors.ErrorCode;

/**
 * @author Mike
 *
 */
public interface PlayerService {

		public ErrorCode Register(String email, String pass, String nickName, boolean sex, String avatar);
		
		public ErrorCode Login(String email, String pass);

		public ErrorCode Logout();
		
		public ErrorCode Edit (String email, String pass, String nickName, boolean sex, String avatar);

}
