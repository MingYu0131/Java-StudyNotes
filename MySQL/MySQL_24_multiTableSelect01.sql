#演示多表查询
#多表查询的本质，就是使用笛卡尔积排列组合出两张表所有可能的组合，然后使用过滤where选出有效的记录。
#多表查询的条件至少要达到表的个数-1，不然就会出现笛卡尔集。
#1、显示雇员名、雇员工资和所在部门的名字
SELECT ename, sal, dname
		FROM emp, dept
		WHERE emp.`deptno` = dept.`deptno`;
#2、显示部门号为10的部门名、员工名和工资
SELECT dname, ename, sal
		FROM emp,dept
		WHERE emp.`deptno` = dept.`deptno` AND emp.deptno = 10;
#3、显示各个员工的姓名、工资和工资的级别
SELECT ename, sal, grade
		FROM emp, salgrade
		WHERE sal BETWEEN losal AND hisal;
#4、显示雇员名，雇员工资以及所在部门的名字，并按部门排序[降序]
SELECT ename, sal, dname, emp.`deptno`
		FROM emp, dept
		WHERE emp.`deptno` = dept.`deptno`
		ORDER BY emp.deptno DESC;
SELECT * FROM salgrade;
SELECT * FROM emp;

#演示自连接
#思考：显示公司员工和他上级的名字
#直接在表名后跟一个名字，就可以给表取别名
SELECT worker.`ename`, boss.`ename` AS boss_ename FROM emp worker, emp boss
		WHERE worker.`mgr` = boss.`empno`;
#自连接的特点	1、把一张表当作两张表使用
#		2、一定要给表取别名

#演示子查询临时表，可以解决很多复杂的查询
#就是在SELECT * from emp,(里面填写select语句) as name
#form一个自己构建的临时表