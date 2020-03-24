package com.cg.go.util;

public class Validate {
	public static boolean  validateUserName(String userName) {
		//boolean flag=false;
	//	System.out.println(userName);
		  boolean flag=userName.matches("[A-Za-z]+");
		 
			return flag;
		}
  
	public static  boolean validatePassWord(String passWord) {
	//boolean flag=false;
		//System.out.println(passWord);
	boolean	flag=passWord.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");//[a-zA-Z0-9].*[@#!].{8,15}");
		
		return flag;
	}
	public static  boolean validateEMail(String emailId) {
		boolean flag=emailId.matches("^([1-zA-Z0-1@.\\s]{1,255})$");//"[a-zA-Z0-9]+(_a-zA-Z0-9+)*@[A-Za-z0-9+)*(.[A-Za-z])");
		
		return flag;
	}
	public static boolean validatePhoneNumber(String phoneNumber) {
		boolean	flag=false;
		flag=phoneNumber.matches("[0-9]{10}+");
		return flag;
	}
}
