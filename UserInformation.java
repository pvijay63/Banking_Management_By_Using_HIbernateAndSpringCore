package com.Bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private long mobilenumber;
	@Column(nullable = false,unique = true)
	private String emailid;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false,unique = true)
	private long aadharnumber;
	@Column(nullable = false,unique = true)
	private int accountnumber;
	@Column(nullable = false,unique = true)
	private int pin;
	@Column(nullable = false,name="IFSCCODE")
	private String ifsccode;
	@Column(nullable = false,unique = true,name="PAN_NUMBER")     
	private String pannumber;
	@Column(nullable = false)
	private double amount;
	
	public UserInformation() {
		// TODO Auto-generated constructor stub
	}

	public UserInformation(int userid, String name, long mobilenumber, String emailid, String address, String gender,
			long aadharnumber, int accountnumber, int pin, String ifsccode, String pannumber, double amount) {
		super();
		this.userid = userid;
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.emailid = emailid;
		this.address = address;
		this.gender = gender;
		this.aadharnumber = aadharnumber;
		this.accountnumber = accountnumber;
		this.pin = pin;
		this.ifsccode = ifsccode;
		this.pannumber = pannumber;
		this.amount = amount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
