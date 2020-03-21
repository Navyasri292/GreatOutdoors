package com.cg.go.util;

public class Validate {
	public static boolean  validateUserName(String userName) {
		//boolean flag=false;
	//	System.out.println(userName);
		  boolean flag=userName.matches("[a-zA-Z0-9]+");
		 
			return flag;
		}

}
