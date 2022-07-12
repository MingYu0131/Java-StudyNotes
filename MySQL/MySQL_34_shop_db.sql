#商店数据库设计练习
#创建商店数据库
CREATE DATABASE shop_db;
#创建商品表
CREATE TABLE goods(
	goods_id INT PRIMARY KEY,
	goods_name VARCHAR(32) NOT NULL DEFAULT '',
	#注意：CHECK的写法
	unitprice DOUBLE CHECK (unitprice >= 1.0 AND unitprice <= 9999.99),
	category VARCHAR(32),
	provider VARCHAR(32));
#创建客户表
CREATE TABLE customer(
	customer_id INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL,
	address VARCHAR(255),
	email VARCHAR(32) UNIQUE,
	#CHECK后需要接属性名称
	sex VARCHAR(8) CHECK (sex IN ('男', '女')),
	card_id INT);
	
#创建购买表
CREATE TABLE purchase(
	order_id INT PRIMARY KEY,
	customer_id INT,
	goods_id INT,
	nums INT,
	#注意：FOREIGN KEY后要接括号
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY (goods_id) REFERENCES goods(goods_id));	
	
	