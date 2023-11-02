# BankingApplication
Simple bank application which simulates the basic operations such as Deposit,Withdraw,UpdatePin and Transfer Amount 
Banking Application 

Overview
This is a simple standalone banking application developed in Java that uses JDBC (Java Database Connectivity) to interact with a database.
The application allows you to manage employees and customers, and perform basic banking operations like deposit, withdraw, and transfer.

Prerequisites
Java Development Kit (JDK)
MySQL or any other relational database server

Setup
1.Open the project in your favorite Java IDE.
2.Create a MySQL database for the application. 
db.url=jdbc:mysql://localhost:3306/bankapplication
db.user=root
db.password="set password sa per requirment"

Employee Management
Use the application to add, update, or remove employees from the database.

Customer Management
Add, update, or remove customers from the database.

Banking Operations
The application allows you to perform basic banking operations:
(Note:Initial amount while adding customer is 500)
Deposit: Add funds to a customer's account.
Withdraw: Withdraw funds from a customer's account.
Transfer: Transfer funds between two customer accounts.

Contributing
Contributions are welcome! If you have any improvements or new features to add, please follow these steps:

Fork the repository.
Create a new branch for your feature: git checkout -b feature-name
Make your changes and commit them: git commit -m 'Add feature-name'
Push to your branch: git push origin feature-name
Open a pull request to the main repository.


Tables Description :
Employee Database
![employee](https://github.com/SuhasSindhuvadi/BankingApplication/assets/134517158/547aee0d-cc8e-421b-b7dd-2a50759ecdf4)
Customer Database
![customer](https://github.com/SuhasSindhuvadi/BankingApplication/assets/134517158/d00c3362-c4c5-4b87-a373-5d3a0febdcd4)



