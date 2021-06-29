package com.nagarro.employeemanagement.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ecode;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "edob")
	private Date edob;
	
	public Employee() {
		
	}
	
	
	public Employee(int ecode, String ename, String location, String email, Date edob) {
		super();
		this.ename = ename;
		this.location = location;
		this.email = email;
		this.edob = edob;
	}
	public long getEcode() {
		return ecode;
	}
	public void setEcode(int ecode) {
		this.ecode = ecode;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEdob() {
		return edob;
	}
	public void setEdob(Date edob) {
		this.edob = edob;
	}
	
	
}