package com.bank.application;

import java.sql.SQLException;
import java.util.List;

public interface Employee {
	/*method to display list of employees in bank
	 * throw SQLException and SQLException*/ 
List<BankEmployee> empDetails() throws ClassNotFoundException,SQLException;
/*method to add employee to bank
 * throw SQLException and SQLException*/
void addEmp(int id, String name, int age, String email, long phno, String dept, String pwd)throws ClassNotFoundException,SQLException;
/*method to delete employees from bank
 * throw SQLException and SQLException*/
void deleteEmp(int id)throws ClassNotFoundException,SQLException;
/*method to update  employee of bank
 * throw SQLException and SQLException*/
void updateEmp(BankEmployee e)throws ClassNotFoundException,SQLException;

}
