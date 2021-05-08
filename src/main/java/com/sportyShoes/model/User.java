package com.sportyShoes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String email;
	private Boolean isAdmin;
	@OneToMany
	private List<Purchase> listOfPurchases;
	
	
	private static void userInitData() {
		new User( "david", "password", "David","david@gmail.com", false,null);		

	}


	public User(String userName, String password, String firstName, String email, Boolean isAdmin,
			List<Purchase> listOfPurchases) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
		this.isAdmin = isAdmin;
		this.listOfPurchases = listOfPurchases;
	}
}
