DROP DATABASE lmsDb;

CREATE DATABASE lmsDb;

USE lmsDb;

CREATE TABLE loans(
	loanId int primary key,
	p DECIMAL NOT NULL,
	r DECIMAL NOT NULL,
	emis INT NOT NULL,
	dob date,
	status varchar(10) not null
	
);

INSERT into loans(loanId,p,r,emis,dob,status) values 
(1,10000,0.02,5,null,"PENDING"),
(2,80000,0.02,2,"2020-02-02","ACTIVE"),
(3,90000,0.02,8,"2020-03-03","CLOSED"),
(4,100000,0.02,5,"2020-04-02","REJECTED");
