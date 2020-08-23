DROP DATABASE coronaDb;

CREATE DATABASE coronaDb;

USE coronaDb;

CREATE TABLE products(
	pproductId int AUTO_INCREMENT primary key,
	pproductName varchar(25) ,
	pdescription varchar(70) ,
	pcost DECIMAL(10,3) NOT NULL,
	pavailabilityStatus varchar(15) DEFAULT 'AVAILABLE' CONSTRAINT status_freq CHECK (pavailabilityStatus IN ('AVAILABLE', 'SOLDOUT')) 
	
);

INSERT into products(pproductId,pproductName,pdescription,pcost,pavailabilityStatus) values 
(1,"Face Mask","Disposable Face Mask - Pack of 100",500,"AVAILABLE"),
(2,"Pulse Oximeter","Finger Tip Pulse Oximeter - FPO-94",1500,"AVAILABLE"),
(3,"PPE Kit","Personal Protection Equipment Kit",1000,"AVAILABLE"),
(4,"Digital Thermometer","Digital Thermometer - DT01",700,"SOLDOUT"),
(5,"Hand Sanitizer","Dettol Hand sanitizer",80,"AVAILABLE"),
(6,"Bath Soap","Mysore sandle soap",80,"AVAILABLE")
;


ALTER table TABLE add CONSTRAINT description_ck CHECK (LENGTH(description)>4);