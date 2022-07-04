#1、演示整型tinyint，大小为一个字节，表示范围：有符号 -128~127，无符号 0~255
#2、如果没有指定unsinged，则默认是有符号
CREATE TABLE t3(
	id TINYINT);
CREATE TABLE t4(
	id TINYINT UNSIGNED);
	
INSERT INTO t3 VALUES(127);
SELECT * FROM t3

INSERT INTO t4 VALUES(0);
SELECT * FROM t4