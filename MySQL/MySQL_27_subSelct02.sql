#演示多列子查询：返回多个数据列的子查询语句
#思考：查询和allien部门和岗位完全相同的员工的所有信息
SELECT * FROM emp
	WHERE (deptno, job) = (
		SELECT deptno, job FROM emp
			WHERE ename = 'ALLEN'
	) AND ename <> 'ALLEN';
	
#练习：查询和宋江数学英语和语文成绩完全相同的学生
INSERT INTO student VALUES(9, '明昱', 87, 78, 77);
SELECT * FROM student
	WHERE (english, math, chinese) = (
		SELECT english, math, chinese FROM student
		WHERE `name` = '宋江'
	) AND `name` <> '宋江';

#子查询练习	
#练习：查询每个部门工资高于本部门平均工资的人
SELECT * FROM emp,(SELECT deptno, AVG(sal) AS Avg_sal FROM emp GROUP BY deptno) avg_sal_tab
	WHERE emp.`sal` > avg_sal_tab.Avg_sal AND emp.`deptno` = avg_sal_tab.`deptno`;
#练习：查找每个部门工资最高的人
SELECT MAX(sal), deptno FROM emp
	GROUP BY deptno;
SELECT ename, sal, emp.deptno FROM emp,(
	SELECT MAX(sal) AS max_sal, deptno FROM emp
	GROUP BY deptno) dept_max_sal
	WHERE emp.`sal` = dept_max_sal.`max_sal`;
#练习：查询每个部门的信息（包括：部门名称、编号、地址）和人员数量
SELECT COUNT(ename), deptno FROM emp GROUP BY deptno;
SELECT dept.`deptno`, dept.`dname`, dept.`loc`, dept_people_num.people_num FROM dept,
	(SELECT COUNT(ename) AS people_num, deptno FROM emp GROUP BY deptno) dept_people_num
	WHERE dept.`deptno` = dept_people_num.`deptno`;
#注意：表.*  该表的所有属性
SELECT dept.*, dept_people_num.people_num FROM dept,
	(SELECT COUNT(ename) AS people_num, deptno FROM emp GROUP BY deptno) dept_people_num
	WHERE dept.`deptno` = dept_people_num.`deptno`;