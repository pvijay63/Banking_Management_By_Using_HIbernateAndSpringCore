package com.Bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.entity.UserInformation;

@Component
public class UserDao {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
    @Autowired
	EntityManager entityManager;
    @Autowired
    EntityTransaction entityTransaction;
    
    public void insertUserDetails(UserInformation userInformation)
    {
    	entityTransaction.begin();
    	entityManager.persist(userInformation);
    	entityTransaction.commit();
    	
    }
    
    public UserInformation loginUser(String email,int pin)
    {
    	entityTransaction.begin();
    	String fetch="select u from UserInformation u where u.emailid=?1 and u.pin=?2";
    	Query query=entityManager.createQuery(fetch);
    	query.setParameter(1, email);
    	query.setParameter(2, pin);
    	
    	try
    	{
    	UserInformation res=(UserInformation)query.getSingleResult();
    	entityTransaction.commit();
    	return res;
    	}
    	catch(NoResultException e)
    	{
    		System.out.println("No user found");
    		return null;
    	}
    	
    
    }
    
    
    public void updateUser(UserInformation user)
    {
    	entityTransaction.begin();
    	entityManager.merge(user);
    	entityTransaction.commit();
    	
    	
    }
}
