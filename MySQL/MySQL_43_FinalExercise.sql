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
#注意：排序，越前面的优先级越大
SELECT ename, job, sal FROM emp
	ORDER BY job, sal;
SELECT ename, YEAR(hiredate), MONTH(hiredate) FROM emp ORDER BY MONTH(hiredate),YEAR(hiredate);
SELECT ename, FORMAT(sal/30, 0) AS day_sal FROM emp;
SELECT * FROM emp
	WHERE MONTH(hiredate) = 2;
SELECT ename, DATEDIFF(NOW(), hiredate) AS work_day, FORMAT(DATEDIFF(NOW(), hiredate)/30,0) AS work_month FROM emp;
SELECT ename AS name_include_A FROM emp
	WHERE LOCATE('A', ename) <> 0;
	
#8、多表查询
SELECT * FROM dept;
SELECT * FROM emp;
SELECT deptno, COUNT(deptno) AS num FROM emp
	GROUP BY deptno
	HAVING num >= 0;
SELECT * FROM emp
	WHERE sal > (SELECT sal FROM emp WHERE ename = 'SMITH');
#注意：时间越新越大
SELECT * FROM emp AS emp1, emp AS emp2
	WHERE emp1.mgr = emp2.empno AND emp1.hiredate > emp2.hiredate;
#注意：这里应该使用外连接，因为emp表中存在dept表中存在但是emp中不存在的部门，直接连接会丢失这个部门
SELECT dname, emp.* FROM (emp RIGHT JOIN dept ON dept.deptno = emp.deptno);
SELECT ename, job, dept.dname FROM emp,dept
	WHERE emp.deptno = dept.deptno AND job = 'CLERK';
SELECT job FROM emp
	GROUP BY job
	HAVING MIN(sal) > 1500;
SELECT ename, job, emp.deptno FROM emp,dept
	WHERE emp.deptno = dept.deptno AND dname = 'SALES'; 
SELECT ename, sal FROM emp
	WHERE sal > (SELECT AVG(sal) FROM emp);
	
SELECT ename, sal FROM emp
	WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);
#注意：实现求时间差应该用DATEDIFF()函数而不是直接减
SELECT deptno, COUNT(ename) people_num, FORMAT(AVG(sal), 0) avg_sal, AVG(DATEDIFF(NOW(), hiredate)) avg_work_day FROM emp
	GROUP BY deptno;
SELECT dname, emp.deptno, loc, IF(COUNT(*) = 1, 0, COUNT(*)) AS people_num 
	FROM (emp RIGHT JOIN dept ON emp.deptno = dept.deptno)
	GROUP BY dname, emp.deptno, loc;
SELECT dept.deptno, dept.dname, loc, COUNT(*) FROM emp, dept WHERE dept.deptno = emp.deptno
	GROUP BY dept.deptno, dept.dname, loc;
SELECT dept.deptno, temp.c AS people_num, dept.dname, dept.loc FROM dept, (
	SELECT COUNT(*) AS c, deptno FROM emp
	GROUP BY deptno) temp
	WHERE dept.deptno = temp.deptno;
SELECT job, MIN(sal) FROM emp
	GROUP BY job;

















