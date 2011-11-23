package com.bostonunisoft.students.monopoly.helpers.parser;

import java.util.StringTokenizer;

public class Parser {
  
	enum Cmd {
		REG,LOGIN,EDIT,LOGOUT,NEWGAME,JOINGAME,STARTGAME,KICK,MOVE;
	}
	
	public static String[] parsCMD(String str){
		StringTokenizer st = new StringTokenizer(str,"=",false);
		String[] returnString=new String[2];
		returnString[0]= st.nextToken();
		returnString[1]= st.nextToken();
		return returnString;
	}
	
	
	
}
