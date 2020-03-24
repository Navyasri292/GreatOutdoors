package com.cg.go.service;

import java.util.List;


import com.cg.go.Exception.UserException;
import com.cg.go.bean.User;
import com.cg.go.dao.UserDao;
import com.cg.go.dao.UserDaoMapImpl;
import com.cg.go.util.Validate;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	public UserServiceImpl()
	{
		userDao = new UserDaoMapImpl();
	}

//	@Override
//	public boolean  validateUserName(String userName) {
//	//boolean flag=false;
//	  boolean flag=userName.matches("[a-zA-Z0-9]+");
//	 
//		return flag;
//	}

//	@Override  
//	public boolean validatePassWord(String passWord) {
//	//boolean flag=false;
//		//System.out.println(passWord);
//	boolean	flag=passWord.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");//[a-zA-Z0-9].*[@#!].{8,15}");
//		
//		return flag;
//	}

	
//  public boolean validateReenterPassword(String reenterPassword) 
//	{
//     boolean flag=reenterPassword.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
//		
//		return flag;
//	}	
    
	//@Override
//	public boolean validateEMail(String eMail) {
//		//boolean flag=false;
//		boolean flag=eMail.matches("^([1-zA-Z0-1@.\\s]{1,255})$");//"[a-zA-Z0-9]+(_a-zA-Z0-9+)*@[A-Za-z0-9+)*(.[A-Za-z])");
//		return flag;
//	}
//
//	@Override
//	public boolean validatePhoneNumber(String phoneNumber) {
//	boolean	flag=false;
//	flag=phoneNumber.matches("[0-9]{10}+");
//		return flag;
//	}

	@Override
	public void register(User user) throws UserException 
	{
		String username=user.getUserName();
		boolean flag1=Validate.validateUserName(username);
		if(!flag1)
		{
			throw new UserException("User name should contain only  alphabets");
		}
		
	
		
		String passWord=user.getPassWord();
		boolean flag2=Validate.validatePassWord(passWord);
		if(!flag2)
		{
			throw new UserException("password should contain atleast one uppercase character, lowercase character, one digit, and one special character");
		}
		
		
		String emailid=user.getEmail();
		boolean flag4=Validate.validateEMail(emailid);
		if(!flag4)
		{
			throw new UserException("email id should be in correct format");
		}
		String phoneNumber=user.getPhoneNum();
		boolean flag3=Validate.validatePhoneNumber(phoneNumber);
		if(!flag3)
		{
			throw new UserException("Phone number should contain 10 digits");
		}
		userDao.register(user);
	}

	@Override
	public boolean  login(String str1, String str2) throws UserException 
	{ 		boolean flag1=Validate.validateUserName(str1);
		if(!flag1)
		{
			throw new UserException("User name should contain alphabets and numbers");
		}
		
		boolean flag2=Validate.validatePassWord(str2);
		if(!flag2)
		{
			throw new UserException("password should contain atleast one uppercase character, lowercase character, one digit, and one special character");
		}
	
		return userDao.login(str1, str2);
	}
	@Override
	public boolean logout(String str) throws UserException
	{
		boolean flag1=Validate.validateUserName(str);
		if(!flag1)
		{
			throw new UserException("User name should contain alphabets and numbers");
		}

		return userDao.logout(str);
	}

	@Override
	public List<User> ViewAllUsers() throws UserException 
	{
		
		return userDao.ViewAllUsers();
		}

	
	

}
