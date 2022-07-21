#1、针对emp、dept、salgrade三张表创建一个视图，可以显示雇员编号，雇员名称，雇员部门名称和薪水级别
CREATE VIEW my_view02 AS
	SELECT empno, ename, dname, grade FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno
	AND (sal >= losal AND sal <= hisal);
DESC my_view02;
#如何显示员工的姓名、薪水和薪水级别？
SELECT ename, sal, grade FROM emp, salgrade
	WHERE sal >= losal AND sal <= hisal;
	
UPDATE emp SET sal = 800 WHERE ename = 'SMITH';
SELECT * FROM salgrade;