package com.cg.go.pl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.go.Exception.UserException;
import com.cg.go.bean.User;
import com.cg.go.service.UserService;
import com.cg.go.service.UserServiceImpl;
import com.cg.go.util.Validate;

public class Client {

	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		UserService userService=new UserServiceImpl();
		int choice=0;
		User user=null;
		List<User> list=null;
		while(choice!=5)
		{
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.Logout");
		System.out.println("4.ViewAllusers");
		System.out.println("5.Exit");
		try
		{
		System.out.println("Enter your choice");
		choice=scr.nextInt();
		switch(choice)
		{
		case 1:
			String username="";
			scr.nextLine();
		
		     do {  System.out.println("Enter the user name");
		    
		        username=scr.nextLine();
		      if(!Validate.validateUserName(username))  
          {
    	  System.err.println("name should contain only alpha");
          }
		       }		       
		       while(Validate.validateUserName(username)==false);
		       
		       
		       String passWord="";
		       
		      do { System.out.print("Enter the password");
		       passWord=scr.nextLine();
		       if(!Validate.validatePassWord(passWord))
		       {
		    	   System.err.println("password should contain atleast one uppercase character, lowercase character, one digit, and one special character");
		       }
		      }
		      while(Validate.validatePassWord(passWord)==false);
		     
		      String emailid="";
		       do{ System.out.print("Enter the email id ");
		       emailid=scr.nextLine();
		       if(!Validate.validateEMail(emailid))
		       {
		    	   System.err.println("email id should be in correct format");
		       }
		       }
		       while(Validate.validateEMail(emailid)==false);
		       
		       String phonenumber="";
		   do { System.out.print("Enter the phonenumber");
		        phonenumber=scr.nextLine();
		        if(!Validate.validatePhoneNumber(phonenumber))
		        {
		        	System.err.println("phone num should contain 10 digits");
		        }
		   }
		   while(Validate.validatePhoneNumber(phonenumber)==false);
		   
		       user = new User();
		       user.setUserName(username);
		       user.setPassWord(passWord);
		       user.setEmail(emailid);
		       user.setPhoneNum(phonenumber);
		       try
		       {
		       userService.register(user);
		       System.out.println("Registration done succesfully");
		       }
		      catch(UserException e)
		       {
		           System.err.println(e.getMessage());
		       }
		       break;
		case 2:
		try
		{
		scr.nextLine();
		System.out.println("enter the user name");
		String username1=scr.nextLine();
		System.out.println("enter the password");
		String password1=scr.nextLine();
		userService.login(username1, password1);
		System.out.println("login done successfully");
		}
		catch(UserException e)
		{
		System.err.println(e.getMessage());
		}
		break;

		case 3:
		try
		{
		scr.nextLine();
		System.out.println("enter the user name");
		String  username1=scr.nextLine();
		userService.logout(username1);
		System.out.println("Logged out successfully");
		}
		catch(UserException e)
		{
		System.err.println(e.getMessage());
		}
		break;
		case 4:
	try
		{
		list=userService.ViewAllUsers();
		for(User u:list)
		{
		System.out.println("User name="+u.getUserName());
		}
		}
		catch(UserException e)
	{
	System.out.println(e.getMessage());
	}
		break;

//		case 5:
//		System.out.println("Thank you");
//		        return ;
//
		      	      
		           
		      }
		
		}
		
catch(InputMismatchException e)
{
	System.out.println("choice should be integer");
	scr.nextLine();
}
		
		
		}
		}
		
}
