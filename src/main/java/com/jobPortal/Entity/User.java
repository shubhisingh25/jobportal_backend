package com.jobPortal.Entity;

import com.jobPortal.Enum.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name; // This is the field Spring Data JPA looks for when you use 'ByName'
	
	@Column(unique=true)
	private String email;
	
    private String password;
    
    private boolean isActive = true;
    
	private Role role;
	
	public User() {}
	
	public User(Long id,String name,String email,String password,boolean isActive,Role role) {
		
		this.id=id;
		this.name=name;
		this.email=email;
		this.password=password;
		this.isActive=isActive;
		this.role=role;
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
