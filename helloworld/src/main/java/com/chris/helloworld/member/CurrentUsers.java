package com.chris.helloworld.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity // This tells Hibernate to make a table out of this class
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"account" , "email"})})

public class CurrentUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int currentusers_id;
       
    private String account;

    private String name;

    private String email;
    
    public CurrentUsers() {};
	
    
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
    ////Name does not need to be unique, only email and account number
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CurrentUsers(String account, String name, String email) {
		super();
		this.account = account;
		this.name = name;
		this.email = email;
	}


}