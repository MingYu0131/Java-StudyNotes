#演示增强group by的使用
#1、显示每种岗位的雇员总数、平均工资
SELECT job, COUNT(job), AVG(sal) FROM emp GROUP BY job;
#2、显示雇员总数，以及获得补助的雇员数
#注意：1、count()只会统计列中的非null项  2、count()这种函数里面可以使用判断函数
SELECT COUNT(ename) AS total_emp_num, COUNT(comm) AS emp_get_bouns FROM emp;
#统计没有获得补助的雇员
SELECT COUNT(ename) AS total_emp_num, COUNT(IF(comm IS NULL, 1, NULL)) AS emp_not_get_bouns FROM emp;
SELECT COUNT(ename) AS total_emp_num, COUNT(*) - COUNT(comm) AS emp_not_get_bouns FROM emp;
SELECT * FROM emp;
#3、显示管理者的总人数
# 思路：在mgr里出现过的就是管理者，所以统计管理者人数就是统计mgr列的非重复项
# 注意：COUNT()，可以使用DISTINCT关键字去重
SELECT COUNT(DISTINCT mgr) FROM emp;
#4、显示雇员工资的最大差额
SELECT FORMAT(MAX(sal) - MIN(sal), 1) AS Sal_gap FROM emp;
#5、统计各个部门的平均工资，且大于1000，按照平均工资从高到低排序，取出前两行记录
#注意：select语句中的顺序：1、group by 2、having 3、order by 4、limit
#CAST()、CONVERT()函数用于转换类型，注意其与FORMAT的区别，FORMAT的返回值是字符串,并没有做到类型转换
SELECT  FORMAT(AVG(sal), 1) FROM emp;
SELECT deptno, CAST(AVG(sal) AS DECIMAL(10, 2)) AS Avg_sal FROM emp 
			GROUP BY deptno 
			HAVING	Avg_sal > 1000
			ORDER BY Avg_sal DESC 
			LIMIT 0,2;
SELECT deptno, FORMAT(AVG(sal), 2) AS Avg_sal FROM emp 
			GROUP BY deptno 
			HAVING	Avg_sal > 1000
			ORDER BY Avg_sal DESC 
			LIMIT 0,2;