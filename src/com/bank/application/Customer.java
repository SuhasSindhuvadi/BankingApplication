package com.bank.application;

import java.sql.SQLException;
import java.util.List;

public interface Customer {
	/*method to add customer
	 * throw SQLException and SQLException*/
	void addCustomer(int cid, String name, String idtype, String idno, int age, long phno, String email,double balance)throws ClassNotFoundException,SQLException;
	/*method to delete customer
	 * throw SQLException and SQLException*/
	void deleteCustomer(int id)throws ClassNotFoundException,SQLException;
	/*method to update customer
	 * throw SQLException and SQLException*/
	void updateCustomer(CustomerDTO c)throws ClassNotFoundException,SQLException;
	/*method to display list of customer
	 * throw SQLException and SQLException*/
	List<CustomerDTO> customerDetails()throws ClassNotFoundException,SQLException;
	/*method to update pin of customer account
	 * throw SQLException and SQLException*/
	boolean updatePin(int pin,int id,long phno)throws ClassNotFoundException,SQLException;
	
}
