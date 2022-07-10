#演示子查询:嵌套在其他select中的select语句，也叫嵌套查询
#单行子查询是指只返回一行数据的子查询语句
#思考：演示如何查询和SIMTH同一个部门的所有员工
SELECT ename AS same_dept_with_simth FROM emp
		WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'SMITH');
		
#多行子查询指返回多行数据的子查询 使用关键字 in		
#练习：如何查询和10号部门里的员工工作相同的员工的名字岗位和工资与部门号但是不包含10号部门员工
 SELECT ename, job, sal, deptno FROM emp
		WHERE job IN (
			SELECT DISTINCT job FROM emp
			WHERE deptno = 10
		) AND deptno != 10;
#注意：MySQL里，不等于可以用 != 或者 <>