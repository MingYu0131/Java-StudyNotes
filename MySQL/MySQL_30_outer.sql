#演示外连接
#思考：如何显示出没有员工的部门
SELECT * FROM dept;
SELECT * FROM emp;
#注意：ONLY_FULL_GROUP_BY是sql_mode默认对group by的配置，他要求SELECT后面接的列必须被GROUP BY后面接的列所包含
#这个配置会使得GROUP BY语句环境变得十分狭窄，所以一般都不加这个配置
SELECT dept.`deptno`, dept.`dname`, COUNT(dept.`loc`)  FROM dept, emp WHERE emp.`deptno` = dept.`deptno`
GROUP BY dept.`deptno`, dept.`dname`;
#可以发现使用普通的多表查询无法查询到40部门的信息，这时就引出外连接
#外连接分为左外连接和右外连接
#先创建两个测试表
CREATE TABLE stu(
	id INT,
	`name` VARCHAR(32)
);
INSERT INTO stu VALUES(1, 'Jack'),(2, 'Tom'), (3, 'kity'), (4, 'nono');
CREATE TABLE exam(
	id INT,
	grade INT
);
INSERT INTO exam VALUES(1, 56),(2, 76), (11, 78);
#1、使用左连接（显示所有人的成绩，若没有成绩也要显示姓名和id，成绩为空）
#语法： 左表 LEFT JOIN 右表 ON 连接条件
SELECT `name`, stu.`id`, grade 
	FROM stu LEFT JOIN exam
	ON stu.`id` = exam.`id`;
#2、使用右外连接（显示所有id，没有名字就显示空）
SELECT `name`, exam.`id`, grade 
	FROM stu RIGHT JOIN exam
	ON stu.`id` = exam.`id`;
#练习：列出部门名称和这些部门的员工信息（名字和工作），同时列出那些没有员工的部门名称，使用左右外连接分别完成
SELECT dept.`dname`, emp.`ename`, emp.`job` FROM dept LEFT JOIN emp
	ON emp.`deptno` = dept.`deptno`;
SELECT dept.`dname`, emp.`ename`, emp.`job` FROM emp RIGHT JOIN dept
	ON emp.`deptno` = dept.`deptno`
	ORDER BY dname;
	
#总结：大部分情况下使用的还是前面的普通多表查询（内连接）



