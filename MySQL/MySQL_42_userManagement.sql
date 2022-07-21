#1、创建一个用户，密码123，并且只可以从本地登录，不让远程登录
#'humingyu'@'localhost' 代表'用户名'@'Host' Host填localhost代表只有本机可以连接
CREATE USER 'humingyu'@'localhost' IDENTIFIED BY '123';
#注意： 如果Host填%，代表所有ip都可以连接到这个数据库，支持远程登录
CREATE USER 'testUser'@'192.168.1.%' IDENTIFIED BY '123';
#不写Host，默认就是%，密码为空
CREATE USER jack;
#注意： 也可以指定特定IP段'testUser'@'192.168.%.%' 代表192.168.*.*的IP都能连接
#出现无法创建用户的错误时需要刷新权限
FLUSH PRIVILEGES;

#2、创建数据库和表
CREATE DATABASE testDb;
CREATE TABLE news(
	id INT PRIMARY KEY,
	content VARCHAR(255));

#3、给新建的用户分配查看news表和添加数据的权限
GRANT SELECT,INSERT ON testdb.news
	TO 'humingyu'@'localhost';

#4、修改密码为abc，使用root用户完成
SET PASSWORD FOR 'humingyu'@'localhost' = PASSWORD('abc');

#5、回收'humingyu'@'localhost' 在表testd.news下的所有权限
REVOKE ALL ON testdb.news
	FROM 'humingyu'@'localhost';
REVOKE SELECT,INSERT ON testdb.news
	FROM 'humingyu'@'localhost';
	
#6、使用root用户删除humingyu
#注意删除用户时，如果其host不是使用的%，需要指定host值
DROP USER 'humingyu'@'localhost';
DROP USER jack;
DROP USER 'testUser'@'192.168.1.%';