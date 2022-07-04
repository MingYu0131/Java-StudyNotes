#演示bit类型的使用
#1、格式：bit(m)，1<=m<=64
#2、数据的范围按照你给的位数来确定，例如bit(8)，代表一个字节0~255
#3、显示是按照2进制的格式显示
#4、查询可以使用十进制查询
CREATE TABLE t5 (num BIT(8));
INSERT INTO t5 VALUES(255);#11111111
SELECT * FROM t5;