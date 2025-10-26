package com.Bank.service;

import java.util.Scanner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.dao.UserDao;
import com.Bank.entity.UserInformation;

@Component
public class UserService {
	

	
	@Autowired
	Scanner scanner;
	
	@Autowired
	UserDao userDao;
	
	public void userRegistration()
	{
		System.out.println("Enter user name");
		String uname=scanner.next();
		scanner.nextLine();
		System.out.println("Enter user mobilenumber");
		long uMobile=scanner.nextLong();
		System.out.println("Enter user emailid");
		String uemail=scanner.next();
		System.out.println("Enter user address");
		String uaddress=scanner.next();
		System.out.println("Enter user gender");
		String ugender=scanner.next();
		System.out.println("Enter user Adhar number");
		long uadhar=scanner.nextLong();
		System.out.println("Enter user Account numbeer");
		int uaccno=scanner.nextInt();
		System.out.println("Enter user pin");
		int upin=scanner.nextInt();
		System.out.println("Enter BAnk IFSCCODE");
		String bIFSc=scanner.next();
		System.out.println("Enter User PAN Number");
		String pannumber=scanner.next();
		System.out.println("Enter Initial Amount");
		double amount=scanner.nextDouble();
		
		UserInformation info=new UserInformation();
		info.setName(uname);
		info.setMobilenumber(uMobile);
		info.setEmailid(uemail);
		info.setGender(ugender);
		info.setAddress(uaddress);
        info.setAadharnumber(uadhar);
        info.setAccountnumber(uaccno);
        info.setPin(upin);
        info.setIfsccode(bIFSc);
        info.setPannumber(pannumber);
        info.setAmount(amount);
        
        userDao.insertUserDetails(info);
        System.out.println("Data inserted");
	}
	
	public void userLogin()
	{
	
		System.out.println("Enter user emailid");
		String uemail=scanner.next();
		System.out.println("Enter pin of account");
		int pin=scanner.nextInt();
		
		UserInformation loginUser = userDao.loginUser(uemail, pin);
		if(loginUser==null)
		{
			System.out.println("No user present with these details");
		}
		else
		{
			System.out.println(" Welcome Login successfully");
			System.out.println("Choose operation u want to perform \n 1.Debit(withdraw) \n 2.Credit(adding money to bank) \n 3.CheckBalance");
			switch(scanner.nextInt())
			{
			case 1:System.out.println("Debit");
			System.out.println("Enter the amount to withdram");
			Double withdrawAmount=scanner.nextDouble();
			if(withdrawAmount<=0)
				System.out.println("Please enter the amount greater than 0");
			else if(withdrawAmount>loginUser.getAmount())
				System.out.println("Insufficient funds in your account"+loginUser.getAmount());
			else
			{
				double ne=loginUser.getAmount()-withdrawAmount;
				loginUser.setAmount(ne);
				userDao.updateUser(loginUser);
				System.out.println("The remaining balance of your account is "+loginUser.getAmount());
			}
			
			break;
			case 2:System.out.println("Credit");
			System.out.println("Enter the amount to deposit ");
			double amount=scanner.nextDouble();
			double d=loginUser.getAmount()+amount;
		    loginUser.setAmount(d);
		    userDao.updateUser(loginUser);
			System.out.println("The amout "+amount+"  successfully credited in your account");
			break;
			case 3:System.out.println("checkbalance");
			System.out.println("Your account balance is "+loginUser.getAmount());
			break;
			default:
				System.out.println("Invalid option please select the valid option ");
			}
		}
	}

}
