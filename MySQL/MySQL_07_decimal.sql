#小数常用的两个：DOUBLE(8bit)和DECIMAL(大小可变)
#1、DECIMAL(M,D)[UNSIGNED] M是数的精度总数，D是小数点（标度）后面的位数，例如DECIMAL(18,9)代表小数点前9位，后也9位
#2、如果D是0，则代表整数
#3、M最大65，D最大30，如果D省略，默认为0，如果M省略，默认为10
#4、如果插入超过精度的数，会四舍五入精度过高的位数
CREATE TABLE t6(id DECIMAL(18, 9));
INSERT INTO t6 VALUES(65535.123456789);
INSERT INTO t6 VALUES(65535.12345678911);
SELECT * FROM t6