
CREATE TABLE users(
username text
);

CREATE TABLE locations(
username text
);

CREATE TABLE accounts(
username text
);

CREATE TABLE customers(
username TEXT,
customerID int PRIMARY KEY,
address TEXT,
sentMoney decimal,
phoneNumber TEXT
);
--------------------------------------------------------------------------------------------


CREATE TABLE buyers(
customerID serial PRIMARY KEY,
username TEXT,
address TEXT,
phoneNumber TEXT
);

CREATE TABLE items(
itemID serial PRIMARY KEY,
itemName TEXT,
departmentID int,
size char(3),
cost decimal,
amountStocked int,
price decimal
);

CREATE TABLE shipmentItems(
quantity int,
shipmentID int REFERENCES shippingLog (shipmentID),
itemID int, --REFERENCES items (itemID)  FOREIGN KEY: establishes a relationship
price decimal,
PRIMARY KEY (shipmentID, itemID)
);

CREATE TABLE shippingLog(
shipmentID serial PRIMARY KEY,
customerID int REFERENCES buyers (customerID)
);

CREATE TABLE bestSellers(
department TEXT,
departmentID int,
item TEXT,
quantitySold int,
price int,
amountSoldTotal int,
itemID int, 
PRIMARY KEY (department, item)
);

DROP TABLE IF EXISTS shippingLog;
TRUNCATE TABLE shippingLog;
DELETE FROM shippingLog;
DELETE FROM shippingLog;

DROP TABLE IF EXISTS shipmentItems;
TRUNCATE TABLE shipmentItems;
DELETE FROM shipmentItems;
DELETE FROM shipmentItems;

DROP TABLE IF EXISTS items;
TRUNCATE TABLE items;
DELETE FROM items;
DELETE FROM items;

DROP TABLE IF EXISTS buyers;
TRUNCATE TABLE buyers;
DELETE FROM buyers;
DELETE FROM buyers;



ALTER TABLE bestSellers ADD COLUMN active boolean;
ALTER TABLE bestSellers ALTER COLUMN active SET DEFAULT TRUE;
SELECT * FROM bestSellers;

---------------------------------------------------------------------------------------

INSERT INTO items (itemName, departmentID, size, cost, amountStocked, price)
VALUES ('Iphones', 1, 's', 600, 350, 800),
		('Paper', 2, 's', .05, 1000, 2),
		('Rope', 3, 'm', 5, 250, 15),
		('Pants', 4, 'm', 2, 350, 20),
		('Apples', 5, 's', .3, 200, .7),
		('Wrenches', 6, 'l', 2, 500, 4);
	--1:tech, 2:house, 3:outdoors, 4:clothes, 5:food 6:tools
	
SELECT * FROM items;


INSERT INTO shipmentItems (quantity, shipmentID, itemID, price)
VALUES (100, 1, 1, 800),
		(200, 1, 5, .7),
		(150, 2, 1, 800),
		(50, 3, 4, 20);
	
	
SELECT * FROM shipmentItems;
select * from shipmentItems where shipmentID = 1;


INSERT INTO shippingLog (customerID)
VALUES (2),
		(3),
		(1),
		(4);
	
	insert into shippingLog (customerID) 
	VALUES (2);
	
	
SELECT * FROM shippingLog;


INSERT INTO buyers (username, address, phoneNumber)
VALUES ('Walmart', '1234 N. Esco st.', '7054228572'),
		('Buyer1', '4321 S. San Marcos Blvd.', '7602238752'),
		('Seller1', '5055 N. Long st.', '7054248534'),
		('Buyer2', '2000 E. Esco Blvd.', '5053458994');

	
	
SELECT * FROM buyers;

UPDATE buyers SET username= 'nerdstop', address= 'test', phonenumber= '444-555-654' WHERE customerid= 1;


--------------------------------------------------------------------------------------------


