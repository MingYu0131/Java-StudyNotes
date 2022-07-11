#约束：确保数据库中的数据满足特定的商业规则，约束包括not null\unique\primary key\foreign key\check五种
#演示主键的使用
#主键是唯一标识行的数据，设置为主键后改列不能重复
CREATE TABLE t12(
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	email VARCHAR(32));
INSERT INTO t12 VALUES(1, 'myb', 'myb@163.com'),(2, 'dd', 'dd@163.com');
INSERT INTO t12 VALUES(1, 'ffw', 'ffw@163.com'); -- 会报错Duplicate entry '1' for key 'PRIMARY'

#主键细节说明
#1、primary key不能重复且不能为null（因为要标识）
#2、一张表最多只能有一个主键，但是可以有复合主键
CREATE TABLE t13(
	id INT,
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY(id, `name`));
INSERT INTO t13 VALUES(1, 'myb', 'myb@163.com'),(2, 'dd', 'dd@163.com');
INSERT INTO t13 VALUES(1, 'myb', 'sa@163.com');-- 报错Duplicate entry '1-myb' for key 'PRIMARY'
#3、主键有两种声明方式，（1）直接在字段后指定 （2）在表定义最后写primary key(列名)
#4、使用DESC(describe) 表名 可以看到主键的情况
DESC t13;

#注意：unique约束，null是可以重复的（如果没有指定not null）
