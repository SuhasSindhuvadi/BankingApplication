package com.bank.application;

import java.sql.SQLException;
//import java.util.List;

public interface Transaction {
	/*method to deposit amount
	 * throw SQLException and SQLException*/ 
void deposit(int acno, double amt)throws SQLException, ClassNotFoundException;
/*method to withdraw amount
 * throw SQLException and SQLException*/ 
void withdrw(int acno,double amt)throws ClassNotFoundException,SQLException;
/*method to transfer amount
 * throw SQLException and SQLException*/ 
void transfer(transactionDTO t)throws ClassNotFoundException,SQLException;

}
