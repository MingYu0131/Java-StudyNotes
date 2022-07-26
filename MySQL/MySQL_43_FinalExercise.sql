#MySQL练习
#2、查看表结构
DESC emp;
DESC dept;

#3、使用简单查询（1）显示所有部门名称（2）显示所有雇员名及其全年收入
SELECT dname FROM dept;
#取别名也可以忽略AS
SELECT ename, sal*12 all_year_sal FROM emp;

#4、限制查询
SELECT ename, sal FROM emp
	WHERE sal > 2850;
SELECT ename, sal FROM emp
	WHERE sal NOT BETWEEN 1500 AND 2850;
SELECT ename, deptno FROM emp
	WHERE empno = 7566;
#注意：可以使用IN (num1,num2)来表示列表
SELECT ename, sal, deptno FROM emp
	WHERE deptno IN (10,30) AND sal > 1500;
SELECT ename, job FROM emp
	WHERE mgr IS NULL;

#5、排序数据
#注意：进行时间相关的比较时，要记住使用字符串表示时间'YYYY-MM-DD'
#MySQL底层进行时间类型相关的比较是将字符串转换成long类型来进行比较的，记住这一点
#ASC ascending 升序 DESC descending 降序 
SELECT ename, job, hiredate FROM emp
	WHERE hiredate >= '1991-2-1' AND hiredate <= '1991-5-1'
	ORDER BY hiredate ASC;
SELECT ename, sal, comm FROM emp
	ORDER BY sal DESC;

#6、复杂查询01
SELECT ename FROM emp WHERE sal > comm AND comm IS NOT NULL;
SELECT ename FROM emp WHERE sal > comm*1.6 AND comm IS NOT NULL;
SELECT ename FROM emp WHERE IFNULL(comm, 0) > sal * 0.6;
SELECT * FROM emp
	WHERE (deptno = 10 AND job = 'MANAGER') OR
	(deptno = 20 AND job = 'CLERK');
SELECT * FROM emp
	WHERE (deptno = 10 AND job = 'MANAGER') OR
	(deptno = 20 AND job = 'CLERK') OR
	(job NOT IN ('CLERK', 'MANAGER') AND sal >= 2000);
SELECT DISTINCT job FROM emp
	WHERE comm IS NOT NULL;
SELECT * FROM emp
	WHERE comm IS NULL OR comm < 100;
SELECT * FROM emp
	WHERE (MONTH(hiredate) = 2 AND DAY(hiredate) = 26) OR
	(MONTH(hiredate)%2 = 0 AND DAY(hiredate) = 28) OR
	(MONTH(hiredate)%2 = 1 AND DAY(hiredate) = 28);
#注意：LAST_DAY(date) 获取date时间所在月份的最后一天
#时间有很多函数，记得查手册
SELECT * FROM emp
	WHERE LAST_DAY(hiredate) - hiredate < = 3;
SELECT * FROM emp
	WHERE ABS(YEAR(hiredate) - YEAR(CURRENT_TIME)) > 12;
SELECT * FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 12 YEAR) < NOW();
SELECT CONCAT(LCASE(LEFT(ename,1)), RIGHT(ename, LENGTH(ename) - 1)) FROM emp;
SELECT REPLACE(ename, LEFT(ename, 1), LCASE(LEFT(ename, 1))) FROM emp;
SELECT ename AS five_words_name FROM emp
	WHERE LENGTH(ename) = 5;
	
#7、复杂查询02
#LOCATE(substr, str) 返回字符串 str中子字符串substr的第一个出现位置，未出现返回0
SELECT ename FROM emp
	WHERE LOCATE('K', ename) = 0;
SELECT REPLACE(ename, 'A', 'a') FROM emp;
SELECT ename, hiredate FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 10 YEAR) <= NOW();
SELECT * FROM emp ORDER BY ename ASC;
SELECT ename, hiredate FROM emp ORDER BY hiredate ASC;



















