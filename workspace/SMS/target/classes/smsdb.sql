DROP DATABASE smsDb;

CREATE DATABASE smsDb;

USE smsDb;

CREATE TABLE Enquiry(
	enquiryId int primary key,
	customerName varchar(25) ,
	mobile DECIMAL(10) NOT NULL,
	vehicleType varchar(10) CONSTRAINT vehicleType_freq CHECK (vehicleType IN ('SADAN', 'CUPY','HATCHBACK')),
	budgetFrom DECIMAL NOT NULL,
	budgetTo DECIMAL NOT NULL,
	status varchar(10) DEFAULT 'OPEN' CONSTRAINT status_freq CHECK (status IN ('OPEN', 'CLOSED')) 
	
	
);

INSERT into Enquiry(enquiryId,customerName,mobile,vehicleType,budgetFrom,budgetTo,status) values 
(1,'swap',9809654367,'SADAN',10000,900000,"OPEN"),
(2,'nix',9809654367,'CUPY',10000,900000,"CLOSED"),
(3,'pk',9809654367,'HATCHBACK',10000,900000,"OPEN"),
(4,'shan',9809654367,'HATCHBACK',10000,900000,"OPEN")
;
