package com.Bank.config;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.Bank")
public class BankConfig {

	@Bean
	public Scanner ScannerClassBean()
	{
		return new Scanner(System.in);
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory()
	{
		return Persistence.createEntityManagerFactory("Bank_System_By_HibernateSpringCore");
	}
	
	@Bean
	public EntityManager etnEntityManager(EntityManagerFactory entityManagerFactory)
	{
		return entityManagerFactory.createEntityManager();
	}
	
	@Bean
	public EntityTransaction entityTransaction(EntityManager entityManager)
	{
		return entityManager.getTransaction();
	}
	
}
