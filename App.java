package com;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Bank.config.BankConfig;
import com.Bank.service.UserService;


public class App 
{
	
	
    public static void main( String[] args )
    {
    	Scanner sc =new Scanner(System.in);
        ApplicationContext con =new AnnotationConfigApplicationContext(BankConfig.class);
        UserService userService = con.getBean(UserService.class);
       // userService.userRegistration();
        System.out.println("Welcome to Banking Application \n 1.TO user registration \n 2.To User login");
        switch (sc.nextInt()) {
		case 1:
			userService.userRegistration();
			break;
		case 2:
			userService.userLogin();
		default:
			System.out.println("Invalid Choice ");
			break;
		}
    }
}
