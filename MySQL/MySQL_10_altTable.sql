#使用ALTER TABLE语句追加、修改或删除列
#在resume后加入image属性
ALTER TABLE employee 
ADD (image VARCHAR(255)) AFTER `resume`;
#修改job字段，使其长度变为60
ALTER TABLE emp
MODIFY job VARCHAR(60)
#删除sex字段
ALTER TABLE emp
DROP sex
#修改表名
RENAME TABLE employee TO emp;
#修改表的字符集规则为utf8
ALTER TABLE emp
CHARACTER SET utf8;
#修改列name的名称为user_name
ALTER TABLE emp
CHANGE COLUMN `name` user_name VARCHAR(32) NOT NULL DEFAULT ''
#查看表结构
DESC emp