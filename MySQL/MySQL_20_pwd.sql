#演示加密函数和系统函数
#1、USER()用于查询MySQL的用户，返回在使用的用户名@IP
SELECT USER() FROM DUAL;
#2、DATABASE()查询当前数据库的名称
SELECT DATABASE() FROM DUAL;
#3、MD5(object) 对对象进行MD5加密
SELECT MD5('mybb') FROM DUAL;
#4、PASSWORD(object) 对对象进行加密，MySQL的密码就是使用这种方式加密的
#查看mysql的user表，authentication_string 就是使用PASSWORD()加密的用户密码
SELECT * FROM mysql.user \G
SELECT PASSWORD('wmy181204') FROM DUAL;