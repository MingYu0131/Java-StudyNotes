#测试str字符串函数的使用
#0、最常用的LENGTH(str) 返回长度，按照字节（utf8编码英文使用1一个字节存储，汉字使用3个）
SELECT LENGTH('胡明昱b') FROM DUAL;
#1、CHARSET(str)返回字符串字符集
SELECT CHARSET(ename) FROM emp;
#2、CONCAT(str[,...])连接多个字符串
SELECT CONCAT(ename,' job is ', job) FROM emp;
#3、UCASE(str)/LACSE(str)将字符串转化成大小写
#4、LEFT(str,len)/RIGHT(str,len)将字符串的左边/右边截取len个字符,从1开始
#5、REPLACE(str,search_str,replace_str)在str中用replace_str替换search_str
#6、STRCMP(str1,str2)逐字符比较两个字符串的大小
#DUAL是MySQL自带的测试用数据库，是空的
SELECT STRCMP('wmy', 'hmy') FROM DUAL;
#7、SUBSTRING(str,position[,len])取子串，从str的position开始[从1开始计算]，取len个字符
#8、LTRIM(str)/RTRIM(str)去除前端或者后端空格
#练习：以首字母小写的方式显示所有员工的姓名，三种方法

SELECT CONCAT(LCASE(LEFT(ename, 1)), RIGHT(ename, LENGTH(ename)-1)) AS low_case_name FROM emp;
SELECT REPLACE(ename, LEFT(ename, 1), LCASE(LEFT(ename, 1))) AS low_case_name FROM emp;
SELECT CONCAT(LCASE(LEFT(ename, 1)), SUBSTRING(ename, 2, LENGTH(job))) AS low_case_name FROM emp;
SELECT * FROM emp;