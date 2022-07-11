#演示CHECK约束：约束字段的有效范围
#注意：在MySql5.7 CHECK没有得到支持只是进行语法校验
#但是在主流sql server中check都是有效的约束
CREATE TABLE t14(
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	sex VARCHAR(32) CHECK (sex IN ('man','woman')),
	sal DOUBLE CHECK (sal > 0 AND sal < 9999));
INSERT INTO t14 VALUES(1, 'myb', 'unkonwn', 100000); -- 可以插入