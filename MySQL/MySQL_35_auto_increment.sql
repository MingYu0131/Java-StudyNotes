#演示自增长:某个字段随插入自动加1，通常用于主键上
#语法：字段名 类型 .. AUTO_INCREMENT
CREATE TABLE t15(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT ' ' );
#演示3种自增长的方式
INSERT INTO t15(`name` ) VALUES('mybb');
INSERT INTO t15 VALUES(NULL, 'mybb');
#在id已经存在的情况下，不知道id应该填什么可以填null，会自增
INSERT INTO t15 (id, `name` ) VALUES(NULL, 'mybb');
#也可以自己填写id，但是会破坏自增的连续
INSERT INTO t15 VALUES(666, 'mybb');
#之后会按照666之后自增
INSERT INTO t15 VALUES(NULL, 'mybb');
SELECT * FROM t15;
#注意1、自增长默认从1开始，可以通过如下命令修改
CREATE TABLE t16(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT ' ' );
ALTER TABLE t16 AUTO_INCREMENT = 666;
INSERT INTO t16 VALUES(NULL, 'mybb');
SELECT * FROM t16;