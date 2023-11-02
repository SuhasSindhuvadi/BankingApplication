package com.bank.application;
/*
 * author:Suhas S J
 * */
public class BankEmployee {
	/*Bank Employee class contains basic information of employees like
	id,name,age,email,phone-number,depardment and password
	*/
private int eid;
private String ename;
private int eage;
private String eemail;
private long ephno;
private String edept;
private String epwd;
public BankEmployee() {
	//zero parameter constructor
}
public BankEmployee(int eid, String ename, int eage, String eemail, long ephno, String edept) {
	//parametarized constructor except the password
	this.eid = eid;
	this.ename = ename;
	this.eage = eage;
	this.eemail = eemail;
	this.ephno = ephno;
	this.edept = edept;
}
public BankEmployee(int eid, String ename, int eage, String eemail, long ephno, String edept,String pwd) {
	//parametarized constructor with all the variables
	this.eid = eid;
	this.ename = ename;
	this.eage = eage;
	this.eemail = eemail;
	this.ephno = ephno;
	this.edept = edept;
	this.epwd=pwd;
}
//getters and setters for all the variables
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getEage() {
	return eage;
}
public void setEage(int eage) {
	this.eage = eage;
}
public String getEemail() {
	return eemail;
}
public void setEemail(String eemail) {
	this.eemail = eemail;
}
public long getEphno() {
	return ephno;
}
public void setEphno(long ephno) {
	this.ephno = ephno;
}
public String getEdept() {
	return edept;
}
public void setEdept(String edept) {
	this.edept = edept;
}
public String getEpwd() {
	return epwd;
}
public void setEpwd(String epwd) {
	this.epwd = epwd;
}
@Override
	public String toString() {
		//override toString method to print id,name,phone,email,dept of employee
		return eid+" "+ename+" "+ephno+" "+eemail+" "+edept+"\n";
	}
}
