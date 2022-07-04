#创建表的操作，注意如果不指定字符集set，关联规则collate，引擎engine，默认跟随数据库的设置
CREATE TABLE `user`
(
	id INT,
	`name` VARCHAR(255),
	`password` VARCHAR(255),
	`birthday` DATE
)CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB