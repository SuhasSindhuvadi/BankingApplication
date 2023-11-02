package com.bank.application;

public class CustomerDTO {
private int acno;
private int cid;
private String name;
private String idtype;
private String idno;
private int age;
private long phno;
private String email;
private double balance;
public CustomerDTO() {
}
public CustomerDTO(int acno, int cid, String name, String idtype, String idno, int age, long phno, String email,
		double balance) {
	super();
	this.acno = acno;
	this.cid = cid;
	this.name = name;
	this.idtype = idtype;
	this.idno = idno;
	this.age = age;
	this.phno = phno;
	this.email = email;
	this.balance = balance;
}
public CustomerDTO(int acno,String name,double balance) {
	this.acno = acno;
	this.name = name;
	this.balance = balance;
}
public CustomerDTO(int cid,String name,String idtype, String idno, int age, long phno, String email) {
	this.cid = cid;
	this.name = name;
	this.idtype = idtype;
	this.idno = idno;
	this.age = age;
	this.phno = phno;
	this.email = email;
}
public CustomerDTO(int acno2, double amt) {
	this.acno=acno2;
	this.balance=amt;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdtype() {
	return idtype;
}
public void setIdtype(String idtype) {
	this.idtype = idtype;
}
public String getIdno() {
	return idno;
}
public void setIdno(String idno) {
	this.idno = idno;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public int getAcno() {
	return acno;
}
@Override
	public String toString() {
		
		return cid+" "+acno+" "+name+" "+phno+" "+email+" "+balance;
	}
}
