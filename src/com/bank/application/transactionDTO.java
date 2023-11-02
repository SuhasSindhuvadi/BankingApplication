package com.bank.application;

public class transactionDTO {
private int acno1;
private int acno2;
private double amt;
private int pin;
public transactionDTO() {
	// TODO Auto-generated constructor stub
}
public transactionDTO(int acno1, int acno2, double amt,int pin) {
	super();
	this.acno1 = acno1;
	this.acno2 = acno2;
	this.amt = amt;
	this.pin=pin;
}
public transactionDTO(int acno1, int acno2, double amt) {
	super();
	this.acno1 = acno1;
	this.acno2 = acno2;
	this.amt = amt;

}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
public int getAcno1() {
	return acno1;
}
public void setAcno1(int acno1) {
	this.acno1 = acno1;
}
public int getAcno2() {
	return acno2;
}
public void setAcno2(int acno2) {
	this.acno2 = acno2;
}
public double getAmt() {
	return amt;
}
public void setAmt(double amt) {
	this.amt = amt;
}


}
