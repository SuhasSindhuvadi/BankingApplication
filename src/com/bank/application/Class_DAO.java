package com.bank.application;
//import all the nessasary requirments
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Class_DAO implements Employee,Transaction,Customer{
	/*Data Acess class implements Employee and Transaction Interfaces*/
	
	//List to store and Display List Of Employees
	List<BankEmployee> emp=new ArrayList<BankEmployee>();
	
	//List to store and Display the List Of Customers
List<CustomerDTO> cus=new ArrayList<CustomerDTO>();


	@Override
	public List<BankEmployee> empDetails() throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//create reference of ResultSet interface
		ResultSet rs;
		//query to retrive information of employee
		String query="select * from employee";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		//execute query will return ResultSet
		rs=pstm.executeQuery();
		if(rs.next()) {
			/*retrive the nessasary informations such as 
			 * id,name,age,email,phno,depardment
			 */
			int eid=rs.getInt(1);//get id
			String ename=rs.getString(2);//get name
			int eage=rs.getInt(3);//get age
			String email=rs.getString(4);//get email
			long phno=rs.getLong(5);//get phone number
			String edept=rs.getString(6);//get deparment
			//add the retrived data to List
			emp.add(new BankEmployee(eid, ename, eage, email, phno, edept));
	}
		try {
			//close all the costly resources
		if(con!=null&&pstm!=null&&rs!=null) {
			con.close();
			pstm.close();
			rs.close();
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	//return employee List
		return emp;
	}

	@Override
	public void addEmp(int id, String name, int age, String email, long phno, String dept, String pwd)
			throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//ouery to insert data to employee table
		String query="insert into employee values (?,?,?,?,?,?,?)";
		pstm=con.prepareStatement(query);
		//platform to execute the query
		/*
		 * set all the valus to the placeholders respectivly*/
		pstm.setInt(1, id);//set id to 1st placeholder
		pstm.setString(2, name);//set name to 2nd placeholder
		pstm.setInt(3, age);//set age to 3rd placeholder
		pstm.setString(4, email);//set email to 4th placeholder
		pstm.setLong(5, phno);//set phone number to 5th placeholder
		pstm.setString(6, dept);//set depardment to 6th placeholder
		pstm.setString(7, pwd);//set password to 8th placeholder
		
		//executeUpdate will return integer value
		int update=pstm.executeUpdate();
		//set autcommit to false
		con.setAutoCommit(false);
		if(update>0) {
			//if insertion is sucessfull,
			con.commit();//commit the changes
			System.out.println("Data Saved Sucessfully");
		}
		else {
			System.out.println("Fail to save Data");
			//if insertion is unsucessfull, 
			con.rollback();//rollback
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null) {
				con.close();
				pstm.close();
				
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteEmp(int id) throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to delete an employee with his id
		String query="delete from employee where eid=?";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		//set id to 1st placeholder
		pstm.setInt(1, id);
		//executeUpdate will return integer value
		int update=pstm.executeUpdate();
		//set autcommit to false
		con.setAutoCommit(false);
		if(update>0) {
			//if deletion  is sucessfull,
			con.commit();//commit
			System.out.println("Data Deleted Sucessfully");
		}
		else {
			System.out.println("Fail to Delete Data");
			//if deletion is unsucessfull,
			con.rollback();//rollback
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null) {
				con.close();
				pstm.close();
				
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void updateEmp(BankEmployee e) throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to update employee data
		String query="update employee set ename=?,eage=?,email=?,ephno=?,edept=?,epwd=? where eid=?";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		/*set all the values to placeholder using the getters
		 * passing the reference od BankEmployee e 
		 * the variables are private so we need to use the getters to acess the data*/
        pstm.setString(1, e.getEname());//get name
        pstm.setInt(2, e.getEage());//get age
        pstm.setString(3, e.getEemail());//get email
        pstm.setLong(4, e.getEphno());//get phonenumber
        pstm.setString(5, e.getEdept());//get depardment
        pstm.setString(6, e.getEpwd());//get passworld
        pstm.setInt(6, e.getEid());//get id
      //execute update will return integer value
        int update=pstm.executeUpdate();
      //set autcommit to false
		con.setAutoCommit(false);
		if(update>0) {
			//if operation is sucessfull
			con.commit();//commit changes
			System.out.println("Data Deleted Sucessfully");
		}
		else {
			System.out.println("Fail to Delete Data");
			con.rollback();//if updation is unsucessfull rollback 
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null) {
				con.close();
				pstm.close();
				
			}
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
        
	}
/*customer interface*/
	@Override
	public void addCustomer(int cid, String name, String idtype, String idno, int age, long phno, String email,
			double balance) throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to add customer
		String query="insert into customer (cid,aname,aidname,aidno,aage,aphno,abal,aemail) values(?,?,?,?,?,?,?,?)";
	   //platform to execute query
		pstm=con.prepareStatement(query);
	   //set all the variables to respective placeholders
		pstm.setInt(1, cid);//set id
	   pstm.setString(2, name);//set name
	   pstm.setString(3, idtype);//set varification id type
	   pstm.setString(4, idno);//set varification id number
	   pstm.setInt(5,age);//set age
	   pstm.setLong(6, phno);//set phone number
	   pstm.setString(8, email);//set email
	   pstm.setDouble(7, balance);//set initial balance
	 //execute update will return integer value
	   int update=pstm.executeUpdate();
	 //set autcommit to false
		con.setAutoCommit(false);
		if(update>0) {
			//if insertion is sucessfull
			con.commit();//commit changes
			System.out.println("Data Saved Sucessfully");
		}
		else {
			System.out.println("Fail to save Data");
			//if insertion is unsucessfull,rollback 
			con.rollback();
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null) {
				con.close();
				pstm.close();
				
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteCustomer(int id) throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to delete customer
		String query="delete from customer where cid=?";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		//set id to 1st placeholder
		pstm.setInt(1, id);
		//execute update will return integer value
		int update=pstm.executeUpdate();
		//set autcommit to false
		con.setAutoCommit(false);
		if(update>0) {
			//if deletion is sucessfull
			con.commit();//commit the changes
			System.out.println("Data Saved Sucessfully");
		}
		else {
			System.out.println("Fail to save Data");
			//if deletion is unsucessfull,rollback 
			con.rollback();
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null) {
				con.close();
				pstm.close();
				
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void updateCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to update customer
		String query="update customer set aname=?,aidname=?,aidno=?,aage=?,aphno=?,aemail=?,where cid=?";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		/*set all the values to placeholder using the getters
		 * passing the reference od CustomerDTO c 
		 * the variables are private so we need to use the getters to acess the data*/
        pstm.setString(1, c.getName());//set name using getName method
        pstm.setString(2, c.getIdtype());//set id type  using getIdtype method
        pstm.setString(3, c.getIdno());//set id number using getId method
        pstm.setInt(4, c.getAge());//set age using getAge method
        pstm.setLong(5, c.getPhno());//set phone number using getPhone method
        pstm.setString(6,c.getEmail());//set email from getEmail method
        pstm.setInt(7, c.getCid());//set id from getCid method
      //execute update will return integer value
        int update=pstm.executeUpdate();
      //set autcommit to false
		con.setAutoCommit(false);
		if(update>0) {
			//if updation is sucessfull
			con.commit();//commit the changes
			System.out.println("Data updated Sucessfully");
		}
		else {
			System.out.println("Fail to update Data");
			//if updation is unsucessfull rollback 
			con.rollback();
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null) {
				con.close();
				pstm.close();
				
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public List<CustomerDTO> customerDetails() throws ClassNotFoundException, SQLException {
		//create reference of connection interface	
		
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//create reference of ResultSet
		ResultSet rs;
		//query to retrive data
		String query="select * from customer";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		//execute query will return ResultSet
		rs=pstm.executeQuery();
		if(rs.next()) {
			/*retrive account  number,name,balance from customer table*/
			int acno=rs.getInt(2);
			String name=rs.getString(3);
			double bal=rs.getDouble(8);
			System.out.println(acno+" "+name+" "+bal);
			//add data to List
			cus.add(new CustomerDTO(acno, name, bal));
		}
		try {
			//close all the costly resources
			if(con!=null&&pstm!=null&&rs!=null) {
				con.close();
				pstm.close();
				rs.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		//return list
		return cus;
	}

	@Override
	public boolean updatePin(int pin,int id,long phno) throws ClassNotFoundException, SQLException {
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to update customer pin 
		String query="update customer set pin=? where cid=? or aphno=?;";
		//platform to execute the query
		pstm=con.prepareStatement(query);
		/*set id,phno and pin to respective placeholders*/
		pstm.setInt(1, pin);//pin for 1st placeholder
		pstm.setInt(2, id);//id for 2nd placeholder
		pstm.setLong(3, phno);//phonenumber for 3rd placehoder
		
		//execute update will return integer value
		 int update=pstm.executeUpdate();
		//set autcommit to false
			con.setAutoCommit(false);
			if(update>0) {
				//if updation is sucessfull
				con.commit();//commit changes to database
				System.out.println("Data updated Sucessfully");
				//return true
				return true;
			}
			else {
				System.out.println("Fail to update Data");
				//if updation is unsucessfull rollback 
				con.rollback();
			}
			try {
				//close all the costly resources
				if(con!=null&&pstm!=null) {
					con.close();
					pstm.close();
					
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			//unsucessfull return false
		return false;
	}


	@Override
	public void deposit(int acno, double amt) throws ClassNotFoundException,SQLException{
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query  to add balance to account
		String query="update customer set abal=abal+? where acno=?";
		
		//platform to execute the query
		pstm=con.prepareStatement(query);
		
		/*set account number and amount to respective placeholders*/
		pstm.setDouble(1, amt);
		pstm.setInt(2, acno);
		//execute update will return integer value
		 int update=pstm.executeUpdate();
		//set autcommit to false
			con.setAutoCommit(false);
			if(update>0) {
				//if deposit is sucessfull
				con.commit();//commit the changes to database
				
			   
			   System.out.println("Deposit Sucessfully");
			}
			else {
				System.out.println("Fail to Deposit amount");
				//if updation is unsucessfull rollback 
				con.rollback();
			}
			
			try {
				//close all the costly resources
				if(con!=null&&pstm!=null) {
					con.close();
					pstm.close();
					
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public void withdrw(int acno, double amt) throws ClassNotFoundException,SQLException{
		//create reference of connection interface
		Connection con=null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con=DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm=null;
		//query to withdraw amount
		String query="update customer set abal=abal-? where acno=?";
		//platform to execute the query
		pstm=con.prepareStatement(query);
	/*set account number and amount to respective placeholders*/
		pstm.setDouble(1, amt);
		pstm.setInt(2, acno);
		//execute update will return integer value
		 int update=pstm.executeUpdate();
		//set autcommit to false
			con.setAutoCommit(false);
			if(update>0) {
				//if withdraw is sucessfull
				con.commit();//commit the changes to database
			   System.out.println("withdraw Sucessfully");
			}
			else {
				System.out.println("Fail to withdraw amount");
				//if withdraw is unsucessfull rollback 
				con.rollback();
			}
			try {
				//close all the costly resources
				if(con!=null&&pstm!=null) {
					con.close();
					pstm.close();
					
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
	}

	@Override
	public void transfer(transactionDTO t) throws ClassNotFoundException,SQLException{
		//create reference of connection interface
		
		
		
		
			
		//if insertion is sucessfull
		//commit the changes
		//if insertion is unsucessfull rollback 
		//close all the costly resources
		Connection con = null;
		//steps for loading and regestering driver written in reqConnection Method in DB_Connectiors class
		con = DB_Connectors.reqConnection();
		//create reference of PrepredStatment interface
		PreparedStatement pstm, pstm1, pstm2 = null;
		//create reference for resultset
		ResultSet rs = null;
       //query to retrive the pin from customer
		String q = "select * from customer where acno=?";
		//query to deduct amount from sender account
		String query = "update customer set abal=abal-? where acno=? AND pin=?";
		//query to add amount to recipient amount
		String query2 = "update customer set abal=abal+? where acno=?";
		//platform to execute the query1
		pstm = con.prepareStatement(q);
		//platform to execute the query2
		pstm1 = con.prepareStatement(query);
		//platform to execute the query3
		pstm2 = con.prepareStatement(query2);

		con.setAutoCommit(false); // Set auto-commit to false
        //set account number to 1st query placeholder
		pstm.setInt(1, t.getAcno1());//retriving account number from CustomerDTO
		rs = pstm.executeQuery();

		if (rs.next()) {
			//get pin from customer table
		    int pin1 = rs.getInt(9); 
		    //set amount to deduct from sender query/2nd query
		    pstm1.setDouble(1, t.getAmt());
		    //set account number for sender query/2nd query
		    pstm1.setInt(2, t.getAcno1());
		    //set pin for sender query/2nd query
		    pstm1.setInt(3, t.getPin());
		    //set amount for reciver query/3rd query
		    pstm2.setDouble(1, t.getAmt());
		    //set account number for reciver query/3rd query
		    pstm2.setInt(2, t.getAcno2());
		  //execute update will return integer value
		    int update1 = pstm1.executeUpdate();
		  //execute update will return integer value
		    int update2 = pstm2.executeUpdate();
		  //set autcommit to false
           con.setAutoCommit(false);

		    if (update1 > 0 && update2 > 0 && pin1 == t.getPin()) {
		    	//check if pin enterd is equal to actual pin if correct
		    	
		        con.commit();//commit changes to database
		        System.out.println("Transfer Successful");
		    } else {
		        System.out.println("Transfer Unsuccessful");
		        //if unsucessfull rollback transaction
		        con.rollback();
		    }
		} else {
		    System.out.println("Customer with acno=" + t.getAcno1() + " not found");
		}

	}

}
