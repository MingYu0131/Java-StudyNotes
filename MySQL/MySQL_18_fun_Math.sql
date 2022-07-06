#演示常用数学函数
#1、ABS(num) 返回绝对值
SELECT ABS(-2) FROM DUAL;
#2、BIN(num) 将十进制num转化为二进制
SELECT BIN(14) FROM DUAL;
#3、CEILING(num) 向上取整
SELECT CEILING(2.3) FROM DUAL;
#4、FLOOR(num)  向下取整
SELECT FLOOR(-1.7) FROM DUAL;
#5、FORMAT(num, decimal_places)保留小数位数
SELECT FORMAT(1.5654456, 2) FROM DUAL;
#6、HEX(num) 转为16进制，小数会省略
SELECT HEX(1236.3) FROM DUAL;
#7、LEAST(num1, num2, ....)求最小值
#8、MOD(num, denominator)求余
SELECT MOD(16, 3) FROM DUAL;
#9、RAND(seed) 产生一个0~1闭区间的随机数，seed是种子值，用于产生重复的随机数
SELECT RAND() FROM DUAL;
