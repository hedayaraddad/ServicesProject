package com.employee;

public class Employee {

	private String fname ; 
	private String lname ; 
	private int idNum;
	
	public Employee(String fname ,String lname ,int idNum) {
		this.fname=fname ; 
		this.lname =lname ; 
		this.idNum =idNum;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFname() {
		return this.fname;
	}
	public void setFname(String fname) {
		this.fname=fname;
	}
	
	public String getlname() {
		return this.lname;
	}
	public void setlname(String lname) {
		this.lname=lname;
	}
	public int getIdNum() {
		return this.idNum;
	}
	
	public void setIdnum(int idNum) {
		this.idNum=idNum;
	}
	
	@Override
	public String toString() {
		return "employee [name=" + this.fname+" "+this.lname + ", ID=" + this.idNum + "]";
	}
}
