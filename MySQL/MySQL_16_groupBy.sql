#测试GROUP BY语句
#先创建一些测试表
CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
dname VARCHAR(20)  NOT NULL  DEFAULT "",
loc VARCHAR(13) NOT NULL DEFAULT ""
) ;
INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK'), (20, 'RESEARCH', 'DALLAS'), (30, 'SALES', 'CHICAGO'), (40, 'OPERATIONS', 'BOSTON');
#创建表EMP雇员
CREATE TABLE emp
(empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT "", /*名字*/
job VARCHAR(9) NOT NULL DEFAULT "",/*工作*/
mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2)  NOT NULL,/*薪水*/
comm DECIMAL(7,2),/*红利*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;
#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
losal DECIMAL(17,2)  NOT NULL,
hisal DECIMAL(17,2)  NOT NULL
);
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);
#插入emp表数据
INSERT INTO emp VALUES(7369, 'SMITH', 'CLERK', 7902, '1990-12-17', 800.00,NULL , 20), (7499, 'ALLEN', 'SALESMAN', 7698, '1991-2-20', 1600.00, 300.00, 30), (7521, 'WARD', 'SALESMAN', 7698, '1991-2-22', 1250.00, 500.00, 30), (7566, 'JONES', 'MANAGER', 7839, '1991-4-2', 2975.00,NULL,20), (7654, 'MARTIN', 'SALESMAN', 7698, '1991-9-28',1250.00,1400.00,30),
(7698, 'BLAKE','MANAGER', 7839,'1991-5-1', 2850.00,NULL,30), (7782, 'CLARK','MANAGER', 7839, '1991-6-9',2450.00,NULL,10), (7788, 'SCOTT','ANALYST',7566, '1997-4-19',3000.00,NULL,20), (7839, 'KING','PRESIDENT',NULL,'1991-11-17',5000.00,NULL,10), (7844, 'TURNER', 'SALESMAN',7698, '1991-9-8', 1500.00, NULL,30), (7900, 'JAMES','CLERK',7698, '1991-12-3',950.00,NULL,30), (7902, 'FORD', 'ANALYST',7566,'1991-12-3',3000.00, NULL,20), (7934,'MILLER','CLERK',7782,'1992-1-23', 1300.00, NULL,10);
SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

#演示group by，group by用于对查询结果进行分组统计(注意group by的分组只有在划分规则下才有意义)
#having子句用于限制分组的显示结果，类似于where
#1、显示每个部门的平均工资和最高工资
#FORMAT(x, y)函数用于处理小数点，x是数值，y是保留的小数点位数
SELECT deptno,FORMAT(AVG(sal), 2) AS Ave_sal, MAX(sal) AS Max_sal FROM emp
	GROUP BY deptno;
	
#2、显示每个部门的每种岗位的平均薪资和最低薪资
#分解：先求emp表的每个岗位的平均和最低工资，再按部门分组
#如何理解group by两列：类似于将emp表的数据按照job和deptno两项的不同进行划分，最后根据排列组合规则形成多个子集
SELECT deptno, job, FORMAT(AVG(sal), 2) AS Ave_sal, MIN(sal) AS Min_sal FROM emp
	GROUP BY job, deptno ORDER BY deptno;

#3、显示平均工资低于2000的部门号和它的平均工资
#使用别名Avg_sal可以提升效率，因为每次调用函数其实都要使用资源
SELECT deptno, AVG(sal) AS Avg_sal FROM emp
	GROUP BY deptno HAVING Avg_sal<2000;


