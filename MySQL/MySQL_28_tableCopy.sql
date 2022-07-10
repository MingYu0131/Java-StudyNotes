#演示表的复制
#有时为了对某个sql语句进行效率测试，会需要表的复制来创建海量数据
CREATE TABLE my_tab_01(
	id INT,
	`name` VARCHAR(32),
	sal DOUBLE,
	job VARCHAR(32),
	deptno INT
);
DESC emp
SELECT * FROM my_tab_02;
#0、如何复制一张表的列信息
CREATE TABLE my_tab_02 LIKE emp;
#1、如何从别的表复制数据
INSERT INTO my_tab_01
	SELECT empno, `ename`, sal, job, deptno FROM emp;
INSERT INTO my_tab_02
	SELECT * FROM emp;
#2、如何自我复制
INSERT INTO my_tab_01
	SELECT * FROM my_tab_01;
#面试题：如何去掉一张表my_tab_02中的重复记录
#注意是去重，所以要修改原表的记录，需要一张中间表temp
CREATE TABLE my_temp LIKE my_tab_02;
#获取去重的表temp
INSERT INTO my_temp SELECT DISTINCT * FROM my_tab_02;
#删除原表的全部内容
DELETE FROM my_tab_02;
#复制temp的内容到my_tab_02
INSERT INTO my_tab_02
	SELECT * FROM my_temp;
#删除中间表temp
DROP TABLE my_temp;
SELECT * FROM my_tab_02;	