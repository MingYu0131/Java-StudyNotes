#演示视图：数据库管理者不希望表的某些隐私列暴露给用户进行查询，希望就产生了视图的概念
#1、视图是根据基表来创建的，视图其实是虚拟的表，在底层只有一个映射文件，没有实际的数据文件
#2、视图也有列，数据来自基表
#3、通过视图也可以修改表的数据
#4、基表的改变，也会影响到视图的数据

#1、创建视图create view 视图名 as select语句
CREATE VIEW my_view01 AS
	SELECT ename,sal,deptno FROM emp;
SELECT * FROM emp;
#2、更新视图为新的结构alter view 视图名 as select语句
ALTER VIEW my_view01 AS
	SELECT empno,ename,sal FROM emp;
#3、查看创建视图的语句show create view 视图名
#4、删除视图 drop view 视图名1，视图名2
#5、查看视图的结构
DESC my_view01;
#6、修改视图（会影响基表） update
UPDATE my_view01
	SET sal = 9999 WHERE ename = 'SMITH';
SELECT * FROM emp;
#7、修改基表（会影响视图）
UPDATE emp
	SET sal = 99 WHERE ename = 'SMITH';
SELECT * FROM my_view01;
#8、视图可以在视图的基础上创建视图