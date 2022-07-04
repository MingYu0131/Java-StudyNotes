#讲解字符型几个常用的数据类型：CHAR、TEXT、VARCHAR
#1、CHAR(size) 固定长度字符串，size在1~255，代表字符的个数，不是字节
#2、VARCHAR(size) 可变长度字符串，size的范围和编码级有关，代表字符数
#3、注意VARCHAR能表示的字符数和字符集有关，例如utf8用三个字节存储一个字符，且VARCHAr有1~3个字符用于存储大小
#所以使用utf8编码的VARCHAR最大有(65535 - 3)/3 = 21844个字符
#4、VARCHAR的实际使用的存储空间和存放情况有关，例如VARCHAR(255)但是只存了"ab"两个字符，那么只占两个字符的空间
#5、CHAR有容易浪费空间的坏处，空间在定义时就确定了
#6、CHAR的好处是速度比VARCHAR更快
CREATE TABLE t7 (`name` VARCHAR(21844));

CREATE TABLE t8 (`name` CHAR(255));
#gbk使用2个字节表示一个字符，故可以存放(65535 - 3)/2 = 32766个字符
CREATE TABLE t9 (`name` VARCHAR(32766)) CHARSET gbk;