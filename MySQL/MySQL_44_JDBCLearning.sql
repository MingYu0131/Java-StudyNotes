#创建JDBC测试用的数据库mybb_02
CREATE DATABASE mybb_02 CHARACTER SET utf8 COLLATE utf8_bin;
#创建测试表演员表
CREATE TABLE actor(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	sex CHAR(1) NOT NULL DEFAULT '女',
	birthday DATETIME,
	phone VARCHAR(12));
	
SELECT * FROM actor;

CREATE TABLE news(id INT PRIMARY KEY AUTO_INCREMENT, content VARCHAR(255) NOT NULL DEFAULT '', NAME VARCHAR(32) NOT NULL DEFAULT '');
DESC news
SELECT * FROM news;

#探究SQL注入
#原理：利用SQL查询变量是直接替换的这一特点，在使用jdbc statement接口时会有此类问题
CREATE TABLE users(
	username VARCHAR(32) PRIMARY KEY,
	`password` VARCHAR(32) NOT NULL);
INSERT INTO users VALUES('mybb', '123456');
#输入用户名为: 1' or
#输入密码为： or '1'= '1
#当执行如下SELECT语句时会暴漏密码
SELECT username, `password` FROM users
	WHERE username = '1' OR' and `password` = 'OR '1'= '1';