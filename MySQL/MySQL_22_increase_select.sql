#演示查询的各种细节
#1、时间也是可以比较的，越早的时间越大，且时间格式要一致
#查找1992.1.1后入职的员工
SELECT ename, hiredate FROM emp WHERE hiredate <= '1992-1-1';

#2、LIKE操作符，专门进行模糊查询，模糊符号：%：表示0到多个字符 _：表示单个字符
#显示首字母为S的员工姓名和工资
SELECT ename, sal FROM emp WHERE ename LIKE 'S%';
#显示第三个字符为大写O的所有员工和工资
SELECT ename, sal FROM emp WHERE ename LIKE '__O%';
#显示没有上级的雇员
SELECT ename, mgr, sal FROM emp WHERE mgr IS NULL;
#查询表结构
DESC emp

#3、order by子句可以叠加使用，例如下面这个需求
#按照部门号升序而雇员工资降序排序，显示雇员的信息
SELECT * FROM emp ORDER BY deptno ASC, sal DESC;