package com.bank.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class mainclass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 //create object of Class_DAO with Employee reference
		Employee e=new Class_DAO();
		//create object of Class_DAO with Customer reference
		Customer c=new Class_DAO();
		//create object of Class_DAO with Transaction reference
		Transaction t=new Class_DAO();
		/*make 3 choices*/
		int choice=0;
		
		int choice1=0;
		
		int choice2=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1.EMPLOYEE INTERFACE\n"
				+ "2.CUSTOMER INTERFACE\n"
				+ "\nENTER YOUR CHOICE\n");
		//take 1st choice input 
		 choice=sc.nextInt();
		
		 switch(choice) {
		 //Employee interface
		case 1:
			System.out.println("1.ADD EMPLOYEE\n"
					+ "2.UPDATE EMPLOYEE\n"
					+ "3.DELETE EMPLOYEE\n"
					+ "4.LIST OF EMPLOYEE\n"
					+ "5.EXIT\n");
			
			do {
			 choice1=sc.nextInt();
			 
			switch(choice1) {
			
			case 1://add employee
				System.out.println("Assign Id Of Employee");//enter id for employee
				int id1=sc.nextInt();
				System.out.println("Enter employee first name");//enter first name of employee
				String fn1=sc.next();
				System.out.println("Enter employee last name");//enter last name of employee
				String fn2=sc.next();
				System.out.println("Enter employee age");//enter employee age
				int age1=sc.nextInt();
				System.out.println("Enter employee email");//enter employee email
				String email1=sc.next();
				System.out.println("Enter employee phone number");//enter employee phone number
				long phno1=sc.nextLong();
				System.out.println("Assign Employee depardment");//enter employee depardment
				String dept1=sc.next();
				System.out.println("Enter employee password");//enter employee password
				String pass11=sc.next();
				System.out.println("Re-Enter Password");//re-enter employee password
				String pass12=sc.next();
				String fullname=fn1+" "+fn2;//full name of employee
				if(pass11.equals(pass12)) {
					//validate employee password
					//call method addEmp
					e.addEmp(id1, fullname, age1, email1, phno1, dept1, pass12);
				
				}
				else {
					
					System.out.println("Incorrect passworld try again");
				}
				break;
				
			case 2://update employee
				System.out.println("Enter Id Of Employee to update");//enter id of employee to update
				int id2=sc.nextInt();
				System.out.println("Enter employee first name to update");//enter first name of employee to update
				String fn3=sc.next();
				System.out.println("Enter employee last name to update");//enter last name of employee to update
				String fn4=sc.next();
				System.out.println("Enter employee age to update");//enter age of employee to update
				int age2=sc.nextInt();
				System.out.println("Enter employee email to update");//enter email of employee to update
				String email2=sc.next();
				System.out.println("Enter employee phone number to update");//enter phone number of employee to update
				long phno2=sc.nextLong();
				System.out.println("Assign Employee depardment to update");//enter depardment of employee to update
				String dept2=sc.next();
				System.out.println("Enter employee password to update");//enter password of employee to update
				String pass21=sc.next();
				System.out.println("Re-Enter Password to update");//conform password
				String pass22=sc.next();
				String fullname2=fn3+" "+fn4;//update full name
				if(pass21.equals(pass22)) {
					//validate password
					//call method updateEmp
					e.updateEmp(new BankEmployee(id2, fullname2, age2, email2, phno2, dept2,pass22));
				
				}
				else {
					System.out.println("Incorrect passworld try again");
				}
				break;
				
			case 3://delete employee
				System.out.println("Enter id of employee to delete");
				int id3=sc.nextInt();//enter id to delete
				//call method deleteEmp
				e.deleteEmp(id3);
				break;
				
			case 4://list of employee
				System.out.println("Details Of Employee:");
				//list for details of employee
				List<BankEmployee> b1=e.empDetails();
				for(BankEmployee b:b1) {//for each loop to traverse list
					System.out.println(b);
				}
				b1.clear();//clear the list so that again if same choice is given then duplicate entery eill not come
				break;
				
			case 5://exit 
				break;
				default:
					break;
			}
			}while(choice1!=5);
			break;
		case 2:
			//customer interface
			System.out.println("1.ADD CUSTOMER\n"
					+ "2.UPDATE CUSTOMER\n"
					+ "3.DELETE CUSTOMER\n"
					+ "4.LIST OF CUSTOMER\n"
					+ "5.UPDATE PIN\n"
					+ "6.DEPOSIT AMOUNT\n"
					+ "7.WITHDRAW AMOUNT\n"
					+ "8.TRANSFER AMOUNT\n"
					+ "9.EXIT\n");
			
			do {
				 choice2=sc.nextInt();
				 switch(choice2) {
				 case 1://add customer
					 System.out.println("Assign Id Of Customer");//add id to customer
						int id1=sc.nextInt();
						System.out.println("Enter Customer first name");//add first name of customer
						String fn1=sc.next();
						System.out.println("Enter Customer last name");//add last name of customer
						String fn2=sc.next();
						System.out.println("Enter Customer age");//add age of customer
						int age1=sc.nextInt();
						System.out.println("Enter Customer email");//add email of customer
						String email1=sc.next();
						System.out.println("Enter Customer phone number");//add phone number of customer
						long phno1=sc.nextLong();
						System.out.println("Enter varification ID Type ");//add varificattion id type of customer
						String itype=sc.next();
						System.out.println("Enter ID number");//add  varification id number of customer
						String num=sc.next();
						System.out.println("Enter Amount for initial deposit(amount grater than 500)");//enter initial deposit of 500 or above
						double amt=sc.nextDouble();
						String name=fn1+" "+fn2; //full name
						if(amt>500) {
							//check if amount grater than 500
							//call method addCustomer
							c.addCustomer(id1, name, itype, num, age1, phno1, email1, amt);
						}
						else {
							System.out.println("Amount grater than 500");
						}
						break;
						
				 case 2://edit customer
					 System.out.println("Enter Id Of Customer to update");//update customer id
						int id2=sc.nextInt();
						System.out.println("Enter Customer first name to update");//update customer first name
						String fn3=sc.next();
						System.out.println("Enter Customer last name to update");//update customer last name
						String fn4=sc.next();
						System.out.println("Enter Customer age to update");//update customer age
						int age2=sc.nextInt();
						System.out.println("Enter Customer email to update");//update customer email
						String email2=sc.next();
						System.out.println("Enter Customer phone number to update");//update customer phone number
						long phno2=sc.nextLong();
						System.out.println("Enter varifiv=cation ID Type to update");//update customer varification id type
						String itype2=sc.next();
						System.out.println("Enter ID number to update");//update customer varification id number
						String num2=sc.next();
						String name2=fn3+" "+fn4;//updated full name
						//call method updateCustomer
						c.updateCustomer(new CustomerDTO(id2, name2, itype2, num2, age2, phno2, email2));
						break;
						
				 case 3://delete customer
					 System.out.println("Enter ID of Customer to Delete");//enter id of customer to delete
					 int id3=sc.nextInt();
					 c.deleteCustomer(id3);
					 break;
					 
				 case 4://list of customer
					 System.out.println("Details Of Employee:");
					 //list of details of employee
						List<CustomerDTO> b1=c.customerDetails();
						//for each loop to traverse list 
						for(CustomerDTO b:b1) {
							System.out.println(b);
						}
						b1.clear();
						break;
				 case 5://update pin 
					 System.out.println("Enter Customer id");//enter customer id
					 int id4=sc.nextInt();
					 System.out.println("Enter Customer Phone Number");//enter customer phone number
					 long phno3=sc.nextLong();
					 System.out.println("Enter Desired pin");//update pin
					 int pin=sc.nextInt();
					//call method updatePin
					 c.updatePin(pin, id4, phno3);
					 break;
					 
				 case 6://deposit amount
					System.out.println("Enter Account Number");//enter account number
					int acno1=sc.nextInt();
					System.out.println("Enter amount to deposit");//enter amount to deposit
					double amount=sc.nextDouble();
                     if(amount>0) {
                    	//call method deposit
                    	  t.deposit(acno1, amount);
                     }
                     else {
                    System.out.println("Invalid amount");
                     }
                     break;
                     
				 case 7://withdraw amount
					 System.out.println("Enter Account Number");//enter account number
						int acno2=sc.nextInt();
						System.out.println("Enter amount to withdraw");//enter amount to withdraw
						double amount2=sc.nextDouble();
	                     if(amount2>0) {
	                    	//call method withdraw
	                    	 t.withdrw(acno2, amount2);
	                     }
	                     else {
	                    System.out.println("Invalid amount");
	                     }
	                     break;
	                     
				 case 8://transfer amount from 1 account to another
					 System.out.println("Enter Sender Account Number");//enter account number of sender
						int acno3=sc.nextInt();
						System.out.println("Enter Reciver account number");//enter account number of reciver
						int acno4=sc.nextInt();
						System.out.println("Enter amount to transfer");//enter amount to transfer
						double amt1=sc.nextDouble();
	                     System.out.println("Enter Pin");//enter sender pin 
	                     int pin1=sc.nextInt();
	                     
	                     if(amt1>0) {
	                    	//call method transfer
	                    	   t.transfer(new transactionDTO(acno3, acno4, amt1, pin1));
	                     }
	                     break;
					 default:
						 break;
				 } 
				 
			}while(choice2!=9);
		default:
			System.out.println("Thank You");
           break;
		}
	
		
		
	}
}
