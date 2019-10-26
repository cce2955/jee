package com.JSPExample;

import java.util.HashMap;
import java.util.HashSet;

public class multiuserregistration {
	
	public HashMap<Integer, String> userdatabase = new HashMap<Integer, String>();
	public HashMap<Integer, String> passdatabase = new HashMap<Integer, String>();
	
	
	public HashMap<Integer, String> getUserdatabase() {
		return userdatabase;
	}
	public void setUserdatabase(HashMap<Integer, String> userdatabase) {
		this.userdatabase = userdatabase;
	}
	public HashMap<Integer, String> getPassdatabase() {
		return passdatabase;
	}
	public void setPassdatabase(HashMap<Integer, String> passdatabase) {
		this.passdatabase = passdatabase;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	private String users;
	private String password;
	String currentUser;
	String currentPassword;
			
}
