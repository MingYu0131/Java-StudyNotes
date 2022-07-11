#演示union连接
#当需要连接两个查询的结果时，可以使用union符号
#union all不排除重复项
SELECT ename, sal, deptno FROM emp WHERE sal > 2500
UNION ALL 
SELECT ename, sal, deptno FROM emp WHERE deptno = 10;

#union排除重复项
SELECT ename, sal, deptno FROM emp WHERE sal > 2500
UNION 
SELECT ename, sal, deptno FROM emp WHERE deptno = 10;