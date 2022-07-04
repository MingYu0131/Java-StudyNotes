#创建数据库，可以指定使用的字符集和校对规则
#默认的字符集为utf-8，校对规则为utf8_general_ci(不区分大小写)
#我们常用的校对规则是utf8_bin(区分大小写)，注意使用COLLATE关键字进行更改
CREATE DATABASE mybb_01 CHARACTER SET utf8 COLLATE utf8_bin
#查询mybb_01的表t1的tom对象，看看是否只有一个tom
SELECT * FROM t1 WHERE NAME = 'tom'