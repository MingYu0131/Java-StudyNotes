#演示外键约束：使用一张表的字段来约束另外一张表的字段，且是相互约束的关系
#（例如在学生表添加新的学生其课程号必须满足在另外一张表，课程表中存在）
#外键约束里有两个角色，主表和从表，从表里面的某个字段是主表的外键
#创建测试表
#主表
CREATE TABLE my_class (
	id INT PRIMARY KEY,
	class_name VARCHAR(32));
INSERT INTO my_class VALUES(1, 'java'),(2,'web');
#外键约束语法：在创建表的字段之后加上FOREIGN KEY(要约束的字段) REFERENCES 主表(字段)
#注意：1、主表用来约束外键的字段一定是主键或者unique约束，因为不唯一标识，可能会出现外键约束模糊的情况
#从表
CREATE TABLE my_student(
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	class_id INT,
	FOREIGN KEY(class_id) REFERENCES my_class(id));
INSERT INTO my_student VALUES(1,'tom',1),(2,'mary',2);
INSERT INTO my_student VALUES(3,'mike',3); -- 报错a foreign key constraint fails
#注意：2、需要表的存储引擎是InnoDB才支持外键
#3、外键的字段类型要和主键的类型一致，长度可以不同
#4、外键字段的值，必须在主键字段中出现过，或者为null（当暂时不知道时候可以填null，前提是主键和外键允许为null）
#5、一旦建立主外键的关系，数据就不能随意删除了
DELETE FROM my_class WHERE id = 1; -- 报错a foreign key constraint fails，因为stu表已经存在指向了