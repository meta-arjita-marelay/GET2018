CREATE DATABASE StoreFront;
USE StoreFront;
#Question 1
#Create all tables of eCommerce Application: StoreFront 
#TABLE users
CREATE TABLE users(
user_id INT PRIMARY KEY AUTO_INCREMENT ,
first_name VARCHAR(25) NOT NULL ,
last_name VARCHAR(25) ,
email_id VARCHAR(50) NOT NULL,
user_password VARCHAR(10) NOT NULL,
user_type VARCHAR(7) CHECK (user_type IN('admin','shopper'))
);

#TABLE address
CREATE TABLE address(
address_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT ,
area VARCHAR(25) NOT NULL,
city VARCHAR(25) NOT NULL ,
state VARCHAR(25) NOT NULL ,
country VARCHAR(25) DEFAULT "india",
pin_code INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

#TABLE category
CREATE TABLE category(
category_id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(25) ,
parent_category INT,
FOREIGN KEY (parent_category) REFERENCES category(category_id)
);

#TABLE product
CREATE TABLE product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(25) NOT NULL,
description VARCHAR(50),
stock INT,
amount INT
);

#TABLE product category relation
CREATE TABLE product_category_relation(
product_id INT,
category_id INT,
PRIMARY KEY(product_id,category_id),
FOREIGN KEY (product_id) REFERENCES product (product_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE
);

#TABLE image
CREATE TABLE image(
image_id INT PRIMARY KEY AUTO_INCREMENT,
product_id INT,
image_name VARCHAR(25),
url VARCHAR(25),
FOREIGN KEY (product_id) REFERENCES product(product_id)
);

#TABLE orders
CREATE TABLE orders(
order_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
address_id INT,
bill_amount INT,
placed_date DATETIME,
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY (address_id) REFERENCES address(address_id)
);

#TABLE order status
CREATE TABLE order_status(
product_id INT,
order_id INT,
status VARCHAR(10) CHECK(status IN ("placed", "shipped", "delivered", "cancelled", "returned")),
quantity INT,
ship_date DATETIME,
deliver_date DATETIME,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE
);

#Write a command to display all the TABLE names present in StoreFront.
SHOW TABLES;

#Write a command to remove Product TABLE of the StoreFront database.
DROP TABLE product_category_relation;
DROP TABLE image;
DROP TABLE order_status;
DROP TABLE product;

#Create the Product TABLE again.
CREATE TABLE product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name varchar(25) NOT NULL,
description varchar(50),
amount INT,
stock INT
);
CREATE TABLE product_category_relation(
product_id INT,
category_id INT,
PRIMARY KEY(product_id,category_id),
FOREIGN KEY (product_id) REFERENCES product (product_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE image(
image_id INT PRIMARY KEY AUTO_INCREMENT,
url varchar(25),
image_name varchar(25),
product_id INT,
FOREIGN KEY (product_id) REFERENCES product(product_id)
);
CREATE TABLE order_status(
order_id INT,
product_id INT,
status VARCHAR(10) CHECK(status IN ("placed", "shipped", "delivered", "cancelled", "returned")),
quantity INT,
ship_date DATETIME,
deliver_date DATETIME,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE
);